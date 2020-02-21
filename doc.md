DTO information
===============

dtos1.Child2
------------

| Filed type                       | Field name    | Description                                  |
| -------------------------------- | ------------- | -------------------------------------------- |
| String                           | id            | Id                                           |
| String                           | description   | Description of this child                    |
| Map\<String, List\<ChildChild2>> | childChildMap | Map of strings to list of ChildChild objects |

dtos1.ChildChild2
-----------------

| Filed type | Field name | Description             |
| ---------- | ---------- | ----------------------- |
| String     | id         | Id                      |
| Child2     | child2     | Reference back to Child |

dtos1.Parent2
-------------

| Filed type    | Field name | Description                                        |
| ------------- | ---------- | -------------------------------------------------- |
| String        | id         | Id                                                 |
| int           | quantity   | Number of children                                 |
| List\<Child2> | child2s    | List of children, each child has extra information |

dtos1.nested.EdgeCase2
----------------------

| Filed type | Field name | Description   |
| ---------- | ---------- | ------------- |
| String     | id         | Identificator |

dtos2.Child
-----------

| Filed type                      | Field name    | Description                                  |
| ------------------------------- | ------------- | -------------------------------------------- |
| String                          | id            | Id                                           |
| String                          | description   | Description of this child                    |
| Map\<String, List\<ChildChild>> | childChildMap | Map of strings to list of ChildChild objects |

dtos2.ChildChild
----------------

| Filed type | Field name | Description             |
| ---------- | ---------- | ----------------------- |
| String     | id         | Id                      |
| Child      | child      | Reference back to Child |

dtos2.Parent
------------

| Filed type   | Field name | Description                                        |
| ------------ | ---------- | -------------------------------------------------- |
| String       | id         | Id                                                 |
| int          | quantity   | Number of children                                 |
| List\<Child> | children   | List of children, each child has extra information |

dtos2.nested.EdgeCase
---------------------

| Filed type | Field name | Description   |
| ---------- | ---------- | ------------- |
| String     | id         | Identificator |

