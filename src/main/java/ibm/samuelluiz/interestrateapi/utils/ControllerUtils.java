package ibm.samuelluiz.interestrateapi.utils;

import org.springframework.data.domain.Page;

import java.util.HashMap;
import java.util.Map;

public class ControllerUtils {

    public static<T> Map<String, Object> generateResponse(Page<T> source) {
        Map<String, Object> response = new HashMap<>();
        response.put("total_items", source.getTotalElements());
        response.put("total_pages", source.getTotalPages());
        response.put("current_page", source.getNumber());
        response.put("results", source.getContent());
        return response;
    }
}
