package dtos1;

import generator.Description;

import java.util.List;
import java.util.Map;

@Description(description = "A description to a class")
public class Child2 {
    @Description(description = "Id")
    public String id;
    @Description(description = "Description of this child")
    public String description;
    @Description(description = "Map of strings to list of ChildChild objects")
    public Map<String, List<ChildChild2>> childChildMap;
}
