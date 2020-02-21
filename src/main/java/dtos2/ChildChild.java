package dtos2;

import generator.Description;

public class ChildChild {
    @Description(description = "Id")
    public String id;
    @Description(description = "Reference back to Child")
    public Child child;
}
