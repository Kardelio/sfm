# Speed Flat Mating
:couple: :couple: :couple: :couple: :couple: :couple:
*Coded by Ben Kadel* <br>

# Overview
The following code was created in order to complete the *'Speed Flat Mating'* technical test.

I used the MVP approach (Model, View, Presenter) in order to separate the presentation layer away from the logic so that the UI works independently from the actual data and logical code that digests it, allowing us to switch out view components for example and still have a functioning app.

For this task there was a simple design spec provided that allowed basic UI layouts to be established but the logic and interactions and user experience was left more open.

## Things of importance
There is a simple single activity in the code base *'EventActivity'* which contains a TabAdapter that allows the switching between two tabs, as detailed in the design specification. Each 'tab' contains a fragment: *'UpcomingFragment'* and *'ArchivedFragment'*, the latter is simply an empty fragment with a layout that contains under construction text (more detail in the 'Things TODO' section)
:sparkles:
# Things TODO
**NOTE:**<br>
Due to time constraints there were several areas that have either been skipped or omitted in orderto create an MVP (Minimum Viable Product) within a reasonable time scale for a technical test.

* The Archived tab is simply a placeholder fragment for the tabs and contains no logic or data or interaction, this is because the specification stated nothing about this tab and its functionality. In the future work would be done here to enable functionality of some kind depending on the wishes of the PO.
* The 'This Week' and 'Next Week' functionality was decided to be skipped for this iteration due to time constraints and the wish to create a production ready MVP. This future work would require a relatively simple date check against the dates provided by the Event objects and they would then be grouped, said groups would EITHER be passed to the Recyclerview instead of a List<Event> and the adapter would be modified to handle that OR (perhaps the less optimal solution) the List<Event> that is captured would be digested and custom header views would be inserted in between the relevant elements, the list would then be passed as normal and there would be multiple viewholder types to render.
* Fake numbers were used in the codebase in order to highlight the telephone call functionality once a card has been clicked, this ofcourse is not good, however the example data object provided detailed nothing about a phone number so therefore it was not included in the example data, however in the future the phone numbers for the venue's would come as part of the object data from the JSON or whatever other source.
* The data source itself was a simple JSON file that was fed into the activity, however this is not what should happen in the future. Future work here would implement a service class that handles service calls to an API endpoint that allows up to date data to be accessed. However due to the MVP approach taken this switch over would be relatively simple and the data source gathered in the repository would simple point elsewhere.

# Finally
...