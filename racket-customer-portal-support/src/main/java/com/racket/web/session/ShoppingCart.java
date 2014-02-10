package com.racket.web.session;

import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import com.racket.commons.models.RacketCommodity;

@Component
@Scope(WebApplicationContext.SCOPE_SESSION)
public class ShoppingCart {

    Map<Long, RacketCommodity> contents;

    public Map<Long, RacketCommodity> getContents() {
        return contents;
    }

    public void setContents(Map<Long, RacketCommodity> contents) {
        this.contents = contents;
    }

}
