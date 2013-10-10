package com.gaems.pnptoolbox.model.item;

import com.gaems.pnptoolbox.model.Book;

/**
 * Interface for all objects representing items.
 */
public interface ItemInterface {
    public Integer getId();
    public void setId(Integer id);

    public String getValue();
    public void setValue(String value);

    public String getName();
    public void setName(String name);

    public String getDescription();
    public void setDescription(String description);

    public Float getWeight();
    public void setWeight(Float weight);

    public String getType();
    public void setType(String type);

    public ItemEffects getItemEffects();
    public void setItemEffects(ItemEffects itemEffects);

    public Book getSourceBook();
    public void setSourceBook(Book book);
}
