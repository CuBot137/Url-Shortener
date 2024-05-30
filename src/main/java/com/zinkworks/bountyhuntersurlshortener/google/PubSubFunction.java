package com.zinkworks.bountyhuntersurlshortener.google;

import com.google.cloud.functions.BackgroundFunction;
import com.google.cloud.functions.Context;
import com.zinkworks.bountyhuntersurlshortener.controller.ControllerUrl;
import com.zinkworks.bountyhuntersurlshortener.model.UrlDto;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Base64;
import java.util.logging.Logger;

public class PubSubFunction implements BackgroundFunction<UrlDto> {
    @Autowired
    private ControllerUrl controllerUrl;
    private static final Logger logger = Logger.getLogger(PubSubFunction.class.getName());
    @Override
    public void accept(UrlDto urlDto, Context context) throws Exception {

        if (urlDto != null && urlDto.getUrl() != null){
            String data = urlDto.getUrl();
            String decodedMessage = new String(Base64.getDecoder().decode(data));
            String shortUrl = String.valueOf(controllerUrl.createShortUrl(decodedMessage));
            logger.info("Your Short URL: "+shortUrl);
        }else {
            logger.warning("No DATA GOOSE");
        }
    }
}
