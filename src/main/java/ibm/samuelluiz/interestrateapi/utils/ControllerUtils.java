package ibm.samuelluiz.interestrateapi.utils;

import ibm.samuelluiz.interestrateapi.controllers.MonthlyInterestRateController;
import ibm.samuelluiz.interestrateapi.models.MonthlyInterestRate;
import org.springframework.data.domain.Page;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

public class ControllerUtils {

    public static Map<String, Object> generateResponse(Page<MonthlyInterestRate> src) {
        Map<String, Object> response = new HashMap<>();
        createLinkToItem(src);
        response.put("total_items", src.getTotalElements());
        response.put("total_pages", src.getTotalPages());
        response.put("current_page", src.getNumber());
        response.put("results", src.getContent());
        return response;
    }

    public static void createLinkToList(MonthlyInterestRate obj) {
            String uuid = obj.get_uuid();
            obj.add(linkTo(methodOn(MonthlyInterestRateController.class).findAll(0, 10000, "")).withRel("list"));
    }

    public static void createLinkToItem(Page<MonthlyInterestRate> src) {
        for (MonthlyInterestRate obj : src.getContent()) {
            String uuid = obj.get_uuid();
            obj.add(linkTo(methodOn(MonthlyInterestRateController.class).findByUUID(uuid)).withSelfRel());
        }
    }
}
