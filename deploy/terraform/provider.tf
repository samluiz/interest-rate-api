terraform {
  required_providers {
    google = {
      source = "hashicorp/google"
      version = "4.51.0"
    }
  }
}

provider "google" {
  credentials = file("C:/.gcp/interestrateapi-credentials.json")
  project = "interest-rate-api"
  region  = "us-east1"
  zone    = "us-east1-b"
}

resource "google_compute_instance" "api-server" {
  name = "interest-rate-api-server"
  machine_type = "e2-micro"
  can_ip_forward = "true"
  boot_disk {
    initialize_params {
      type = "pd-standard"
      image = "ubuntu-os-cloud/ubuntu-2004-lts"
    }
  }
  metadata = {
    startup-script = file("script.tpl")
  }
  tags = ["http-server", "https-server"]
  network_interface {
    subnetwork = google_compute_subnetwork.public-api-subnet.name
    access_config {}
    }
  depends_on = [google_compute_subnetwork.public-api-subnet]
  }