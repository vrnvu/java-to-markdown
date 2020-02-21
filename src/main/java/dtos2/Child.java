package dtos2;

import generator.Description;

import java.util.List;
import java.util.Map;

public class Child {
    @Description(description = "Id")
    public String id;
    @Description(description = "Description of this child")
    public String description;
    @Description(description = "Map of strings to list of ChildChild objects")
    public Map<String, List<ChildChild>> childChildMap;
}
