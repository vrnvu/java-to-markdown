# java-to-markdown

> metaprogramming to generate markdowns of dtos2 objects


Tools used:
- [classgraph](https://github.com/classgraph)
- [Java-Markdown-Generator](https://github.com/Steppschuh/Java-Markdown-Generator)

## Example of execution

DTO information
===============

dtos2.Child
----------

| Filed type                      | Field name    | Description                                  |
| ------------------------------- | ------------- | -------------------------------------------- |
| String                          | id            | Id                                           |
| String                          | description   | Description of this child                    |
| Map\<String, List\<ChildChild>> | childChildMap | Map of strings to list of ChildChild objects |

dtos2.ChildChild
---------------

| Filed type | Field name | Description             |
| ---------- | ---------- | ----------------------- |
| String     | id         | Id                      |
| Child      | child      | Reference back to Child |

dtos2.Parent
-----------

| Filed type   | Field name | Description                                        |
| ------------ | ---------- | -------------------------------------------------- |
| String       | id         | Id                                                 |
| int          | quantity   | Number of children                                 |
| List\<Child> | children   | List of children, each child has extra information |

dtos2.nested.EdgeCase
--------------------

| Filed type | Field name | Description   |
| ---------- | ---------- | ------------- |
| String     | id         | Identificator |

