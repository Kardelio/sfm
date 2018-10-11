# Speed Flat Mating
*Coded by Ben Kadel* <br>
:couple:

# Overview
The following code was created in order to complete the *'Speed Flat Mating'* technical test.

I used the MVP approach (Model, View, Presenter) in order to separate the presentation layer away from the logic so that the UI works independently from the actual data and logical code that digests it, allowing us to switch out view components for example and still have a functioning app.

For this task there was a simple design spec provided that allowed basic UI layouts to be established but the logic and interactions and user experience was left more open.

## Things of importance
There is a simple single activity in the code base *'EventActivity'* which contains a TabAdapter that allows the switching between two tabs, as detailed in the design specification. Each 'tab' contains a fragment: *'UpcomingFragment'* and *'ArchivedFragment'*, the latter is simply an empty fragment with a layout that contains under construction text (more detail in the 'Things TODO' section)

# Things TODO
**NOTE**<br>
Due to time constraints there were several areas that have either been skipped or omitted in orderto create an MVP (Minimum Viable Product) within a reasonable time scale for a technical test.
