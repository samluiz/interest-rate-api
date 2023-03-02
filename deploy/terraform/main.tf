resource "google_compute_subnetwork" "public-api-subnet" {
  ip_cidr_range = "10.0.0.0/16"
  name          = "public-api-subnetwork"
  network       = google_compute_network.api-network.name
  depends_on = [google_compute_network.api-network]
}

resource "google_compute_network" "api-network" {
  name = "api-network"
  auto_create_subnetworks = false
}

resource "google_compute_firewall" "default" {
  name    = "api-firewall"
  network = google_compute_network.api-network.name

  allow {
    protocol = "tcp"
    ports    = ["80", "8080", "1000-2000", "22"]
  }
  priority = 1000
  direction = "INGRESS"
  source_ranges = ["0.0.0.0/0"]
  depends_on = [google_compute_network.api-network]
  source_tags = ["web"]
}