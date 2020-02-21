package dtos2;

import generator.Description;

@Description(description = "A description to a class")
public class ChildChild {
    @Description(description = "Id")
    public String id;
    @Description(description = "Reference back to Child")
    public Child child;
}
