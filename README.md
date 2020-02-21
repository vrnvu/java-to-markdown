# automatic-doc-generator

> metaprogramming to generate markdowns of dtos2 objects


Tools used:
- [classgraph](https://github.com/classgraph)
- [Java-Markdown-Generator](https://github.com/Steppschuh/Java-Markdown-Generator)

## Example of execution

DTO information
===============

---
dtos1.Child2
------------

>A description to a class

| Filed type                       | Field name    | Description                                  |
| -------------------------------- | ------------- | -------------------------------------------- |
| String                           | id            | Id                                           |
| String                           | description   | Description of this child                    |
| Map\<String, List\<ChildChild2>> | childChildMap | Map of strings to list of ChildChild objects |

dtos1.ChildChild2
-----------------

>A description to a class

| Filed type | Field name | Description             |
| ---------- | ---------- | ----------------------- |
| String     | id         | Id                      |
| Child2     | child2     | Reference back to Child |

dtos1.Parent2
-------------

>A description to a class

| Filed type    | Field name | Description                                        |
| ------------- | ---------- | -------------------------------------------------- |
| String        | id         | Id                                                 |
| int           | quantity   | Number of children                                 |
| List\<Child2> | child2s    | List of children, each child has extra information |

dtos1.nested.EdgeCase2
----------------------

>A description to a class

| Filed type | Field name | Description   |
| ---------- | ---------- | ------------- |
| String     | id         | Identificator |

---