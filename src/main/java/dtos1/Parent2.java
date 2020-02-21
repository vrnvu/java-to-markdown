package dtos1;

import generator.Description;

import java.util.List;

public class Parent2 {
    @Description(description = "Id")
    public String id;
    @Description(description = "Number of children")
    public int quantity;
    @Description(description = "List of children, each child has extra information")
    public List<Child2> child2s;
}
