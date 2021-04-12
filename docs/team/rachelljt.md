---
layout: page
title: Rachel Lim's Project Portfolio Page
---

## Project: HEY MATEz

HEY MATEz is a desktop application to get rid of your woes by allowing you to track members and tasks within a club efficiently and easily!
It is a Command Line Interface (CLI) application which handles user requests that are typed into the input box as commands and
it has a GUI created with JavaFX. It is written in Java, and has about 10 kLoC.

Given below are my contributions to the project.

* **New Feature**: Added the ability to delete tasks. (Pull Requests: [\#67](https://github.com/AY2021S2-CS2103T-W14-3/tp/pull/67), [\#106](https://github.com/AY2021S2-CS2103T-W14-3/tp/pull/106), [\#246](https://github.com/AY2021S2-CS2103T-W14-3/tp/pull/246))
    * What it does: Allows the user to delete a specific task given a valid index.
    * Justification: This feature allows the user to delete an existing task in the list based on a given index. 
      Should the user accidentally add a task, they can delete it easily just by using the `deleteTask` command. 
    * Highlights: The implementation was challenging as it required changes to existing commands. When the index is parsed, I had to take into account of the different scenarios. 
      For instance, I had to change the function of isNonZeroUnsignedInteger in StringUtil.java from a boolean function to an 
      int function so that `1` will be returned if the index is a valid integer(positive integer),
      `2` for an invalid integer(non-positive integer) and `3` for an invalid input(spaces, alphanumeric) such that different error messages would be thrown 
      should the index differ from the format.
      

* **New Feature**: Added the ability to view a list of uncompleted tasks. (Pull Requests: [\#117](https://github.com/AY2021S2-CS2103T-W14-3/tp/pull/117), [\#252](https://github.com/AY2021S2-CS2103T-W14-3/tp/pull/252)) 
  * What it does: Allows the user to view a list of tasks that have not been completed.
  * Justification: This feature improves the product significantly because a user can easily view a list of uncompleted tasks upon inputting the command
    which greatly saves the time of the user, instead of manually searching for a list uncompleted tasks. 
  * Highlights: The implementation was challenging as it required me to create another predicate to filter a list of 
    uncompleted tasks. Furthermore, I had to create a boolean function `isCompleted` in the `Task` class instead of calling `task.taskStatus` to prevent breaking the abstraction barrier in
    order to filter the list of uncompleted tasks.
    Also, I had to take into account of the different messages displayed in different situations such as when there are no uncompleted tasks found.
    Lastly, I had to do heavy testing to account for the different scenarios of usage which was quite tedious as some commands
    have to be modified. 
    

* **New Feature**: Added the ability to view a list of unassigned tasks. (Pull Requests [\#162](https://github.com/AY2021S2-CS2103T-W14-3/tp/pull/162), [\#252](https://github.com/AY2021S2-CS2103T-W14-3/tp/pull/252))
  * What it does: Allows the user to view a list of tasks that have not been assigned to any member.
  * Justification: This feature improves the product significantly because a user can easily view a list of unassigned tasks upon inputting the command
    which greatly saves the time of the user, instead of manually searching for a list of unassigned tasks.
  * Highlights: The implementation was challenging as it required me to create another predicate to filter a list of
    unassigned tasks. Furthermore, I had to create a boolean function `isAssigned` in `Task` class instead of calling `task.assignees.isEmpty()` to prevent breaking the abstraction barrier in
    order to filter the list of unassigned tasks. 
    Also, I had to take into account of the different messages displayed in different situations such as when there are no unassigned tasks found.
    Finally, I had to do heavy testing to account for the different scenarios of usage which was quite challenging as some commands
    have to be changed.
    

* **Code contributed**: [RepoSense link](https://nus-cs2103-ay2021s2.github.io/tp-dashboard/?search=&sort=groupTitle&sortWithin=title&since=&timeframe=commit&mergegroup=&groupSelect=groupByRepos&breakdown=false&tabOpen=true&tabType=authorship&zFR=false&tabAuthor=rachelljt&tabRepo=AY2021S2-CS2103T-W14-3%2Ftp%5Bmaster%5D&authorshipIsMergeGroup=false&authorshipFileTypes=docs~functional-code~test-code&authorshipIsBinaryFileTypeChecked=false)


* **Project management**:
  * Create issues
  * Set up unit testing for tasks
  * Managed milestones and issues
  

* **Enhancements to existing features**:
  * Change the User Interface of the app  (Pull requests: [\#110](https://github.com/AY2021S2-CS2103T-W14-3/tp/pull/110), [\#128](https://github.com/AY2021S2-CS2103T-W14-3/tp/pull/128), [\#238](https://github.com/AY2021S2-CS2103T-W14-3/tp/pull/238))
  

* **Documentation**:
  * User Guide:
    * Added documentation for the commands `deleteTask`, `viewTasks`, `viewUncompletedTasks`, `viewUnassignedTasks` (Pull requests: [\#117](https://github.com/AY2021S2-CS2103T-W14-3/tp/pull/117), [\#160](https://github.com/AY2021S2-CS2103T-W14-3/tp/pull/160))
    * Embedded a link to download Java 11 at the Quick Start section (Pull Requests: [\#189](https://github.com/AY2021S2-CS2103T-W14-3/tp/pull/189))
    
  * Developer Guide:
    * Updated the user stories in the Developer Guide (Pull requests: [\#138](https://github.com/AY2021S2-CS2103T-W14-3/tp/pull/138), [\#169](https://github.com/AY2021S2-CS2103T-W14-3/tp/pull/169), [\#274](https://github.com/AY2021S2-CS2103T-W14-3/tp/pull/274))
    * Updated the User Interface UML Diagram, Sequence Diagram in the Developer Guide (Pull requests: [\#185](https://github.com/AY2021S2-CS2103T-W14-3/tp/pull/185))
    * Updated the Architecture Sequence Diagram in the Developer Guide (Pull requests: [\#189](https://github.com/AY2021S2-CS2103T-W14-3/tp/pull/189))
    * Added the implementation explanation for `deleteTask` (Pull requests: [\#185](https://github.com/AY2021S2-CS2103T-W14-3/tp/pull/185))
    * Added activity diagram for `deleteTask` (Pull requests: [\#290](https://github.com/AY2021S2-CS2103T-W14-3/tp/pull/290))
    * Added manual testing instructions for `viewTasks`, `deleteTask`, `viewUnassignedTasks`, `viewUncompletedTasks` (Pull requests: [\#285](https://github.com/AY2021S2-CS2103T-W14-3/tp/pull/285))
  

* **Community**:
  * PRs reviewed (Pull requests: [\#247](https://github.com/AY2021S2-CS2103T-W14-3/tp/pull/247), [\#268](https://github.com/AY2021S2-CS2103T-W14-3/tp/pull/268))
  * Contributed to forum discussions (Examples: [1](https://github.com/nus-cs2103-AY2021S2/forum/issues/182))
  * Reported bugs and suggestions for other teams in the class (Examples: [1](https://github.com/rachelljt/ped/issues/4), [2](https://github.com/rachelljt/ped/issues/1), [3](https://github.com/rachelljt/ped/issues/6))
  

