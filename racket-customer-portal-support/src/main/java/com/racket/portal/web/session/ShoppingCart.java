package com.racket.portal.web.session;

import java.util.Iterator;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import com.racket.commons.models.RacketCommodity;

@Component
@Scope(WebApplicationContext.SCOPE_SESSION)
public class ShoppingCart {

    List<RacketCommodity> contents;

    public List<RacketCommodity> getContents() {
        return contents;
    }

    public void setContents(List<RacketCommodity> contents) {
        this.contents = contents;
    }

    public ShoppingCart add(RacketCommodity commodity) {
        contents.add(commodity);
        return this;
    }

    public void remove(Long id) {
        for (Iterator<RacketCommodity> i = contents.iterator(); i.hasNext();) {
            RacketCommodity commodity = i.next();
            if (commodity.getId() == id) {
                i.remove();
                return;
            }
        }
    }
}
