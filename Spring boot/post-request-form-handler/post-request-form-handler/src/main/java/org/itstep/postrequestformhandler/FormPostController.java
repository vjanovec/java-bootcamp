package org.itstep.postrequestformhandler;

import net.minidev.json.JSONObject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class FormPostController {
    @PostMapping("/form-submit")
    public JSONObject submitForm(String fname, String lname) {
        Map<String, String> values = new HashMap<>();
        values.put("fname", fname);
        values.put("lname", lname);
        return (new JSONObject(values));
    }
}
