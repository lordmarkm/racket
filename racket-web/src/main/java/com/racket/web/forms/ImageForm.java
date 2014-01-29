package com.racket.web.forms;

import javax.validation.constraints.NotNull;

import com.racket.commons.models.Image;

/**
 * 
 * @author mbmartinez
 *
 */
public class ImageForm {

    @NotNull
    private String url;
    private String description;

    public Image toImage() {
        Image image = new Image();
        image.setUrl(url);
        image.setDescription(description);
        return image;
    }

    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    
}
