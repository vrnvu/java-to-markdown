package dtos1;

import generator.Description;

@Description(description = "A description to a class")
public class ChildChild2 {
    @Description(description = "Id")
    public String id;
    @Description(description = "Reference back to Child")
    public Child2 child2;
}
