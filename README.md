# java-to-markdown

Hey there, here is an example:

DTO information
===============

dtos.Child
----------

| Filed type              | Field name    | Description                          |
| ----------------------- | ------------- | ------------------------------------ |
| String                  | id            | Id                                   |
| String                  | description   | Description of this child            |
| Map\<String, ChildChild> | childChildMap | Map of strings to ChildChild objects |

dtos.ChildChild
---------------

| Filed type | Field name | Description             |
| ---------- | ---------- | ----------------------- |
| String     | id         | Id                      |
| Child      | child      | Reference back to Child |

dtos.Parent
-----------

| Filed type  | Field name | Description                                        |
| ----------- | ---------- | -------------------------------------------------- |
| String      | id         | Id                                                 |
| int         | quantity   | Number of children                                 |
| List\<Child> | children   | List of children, each child has extra information |
