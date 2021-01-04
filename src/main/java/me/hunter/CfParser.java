package me.hunter;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class CfParser {

    Methods m = new Methods();

    @PostMapping("/postTesting")
    @ResponseStatus(HttpStatus.CREATED)
    public void createSm(@RequestBody String bodyString) throws JSONException {
        System.out.println("Lol");

    }

    @GetMapping("/textParser")
    public String parser(@RequestParam(value = "cf") String cf) {
        String replaced = cf.replaceAll("-", ",");
        String[] strArr = replaced.split(",", 999);
        int i = 1;
        JSONObject json = new JSONObject();
        String s = "l";

        for(String s : strArr) {
            json.put("cf" + i, s);
            i++;
        }
        return json.toString();
    }
}
