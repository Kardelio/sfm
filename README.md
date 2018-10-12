# Speed Flat Mating
:couple: :couple: :couple: :couple: :couple: :couple:
<br> *Coded by Ben Kadel* <br>

# Overview
The following code was created in order to complete the *'Speed Flat Mating'* technical test.

I used the MVP approach (Model, View, Presenter) in order to separate the presentation layer away from the logic so that the UI works independently from the actual data and logical code that digests it, allowing us to switch out view components for example and still have a functioning app.

For this task there was a simple design spec provided that allowed basic UI layouts to be established but the logic and interactions and user experience was left more open.

## Things of importance
There is a simple single activity in the code base *'EventActivity'* which contains a TabAdapter that allows the switching between two tabs, as detailed in the design specification. Each 'tab' contains a fragment: *'UpcomingFragment'* and *'ArchivedFragment'*, the latter is simply an empty fragment with a layout that contains under construction text (more detail in the 'Things TODO' section)

The UpcomingFragment is where the main logic of the application happens, the layout inflated for the fragment contains a Recyclerview that has a adapter attached to it that gets passed the list of events and then pipes each one into its own view holder.

Once a event card is clicked it fires up the CALL_PHONE intent, after of course checking with the user if the package is permitted to utilize the phone function of the phone, if the user denies the function then nothing happens.

# Things TODO
**NOTE:**<br>
Due to time constraints there were several areas that have either been skipped or omitted in order to create an MVP (Minimum Viable Product) within a reasonable time scale for a technical test.

* The Archived tab is simply a placeholder fragment for the tabs and contains no logic or data or interaction, this is because the specification stated nothing about this tab and its functionality. In the future work would be done here to enable functionality of some kind depending on the wishes of the PO.
* The 'This Week' and 'Next Week' functionality was decided to be skipped for this iteration due to time constraints and the wish to create a production ready MVP. This future work would require a relatively simple date check against the dates provided by the Event objects and they would then be grouped, said groups would EITHER be passed to the Recyclerview instead of a List<Event> and the adapter would be modified to handle that OR (perhaps the less optimal solution) the List<Event> that is captured would be digested and custom header views would be inserted in between the relevant elements, the list would then be passed as normal and there would be multiple viewholder types to render.
* Fake numbers were used in the codebase in order to highlight the telephone call functionality once a card has been clicked, this ofcourse is not good, however the example data object provided detailed nothing about a phone number so therefore it was not included in the example data, however in the future the phone numbers for the venue's would come as part of the object data from the JSON or whatever other source.
* The data source itself was a simple JSON file that was fed into the activity, however this is not what should happen in the future. Future work here would implement a service class that handles service calls to an API endpoint that allows up to date data to be accessed. However due to the MVP approach taken this switch over would be relatively simple and the data source gathered in the repository would simple point elsewhere.

# Other elements I would have addressed
**NOTE:**<br>
Again due to time constraints and the aim to get this delivered by the end of the week there were several areas that have either been skipped or omitted. Some of these include some areas of Android app development that are integral to large scale, network using applications. In this section I will briefly discuss some of these components and how I would utilize them in the future development of this project.

* Dagger 2 - Used for dependency injection. Because this is such a small scale prototype I decided not to implement Dagger due to time constraints and instead focus on setting up an MVP. I would have implemented Dagger in order to remove the constant need for passing around objects such as in the EventPresenter example I had to pass in the View and Repo and this can become problematic and messy when passing around other objects that different classes are using and editing. So Dagger would take all that complexity and mess away and would allow me to inject those required objects and also set up conditions for the objects such as enforcing the Singleton paradigm.
* Retrofit - Used to make HTTP requests. So as stated this prototype in future iterations would rely on an accessible API endpoint hosted somewhere on the web, in order to pass real up to date data to the app. Retrofit is the HTTP request client that I would implement to make the calls across the network to the relevant urls.
* RXJava (Reactive) - Used for a whole bunch of things but mainly for anything that involves Threads and Async tasks. Again because of the current scale of this prototype there was no need for RXJava, however in the future I would implement it using its Thread management abilities and Async task handling in conjunction with network calls made by retrofit.

# Unit Tests
Several unit tests both POJO and Android, have been done in this prototype testing some key functionality however, again due to time constraints the Unit tests included are lacking in completion and content. I would ideally aim for as close to 100% code coverage as possible and ensure that every user journey was covered in the tests. In a future iteration I would ensure that the unit tests are addressed and even consider TDD (Test Driven Development) for future features. I would simply state in this section of the README that I am aware that the unit tests are not complete.

# Branching Strategy
So Version control is vital in any project and I use Git every single day (from the terminal of course :wink:) and I would like to just point out that no branching strategy was implemented here as it was just myself working from the ground up on a single task. I made all of my changes to the master branch, which of course I would never do in a real development environment. If work continued on this solution in the future I would take the 'stable' version of the app from master and branch out for every features/bug/tweek that would need to be done, I would then submit pull requests to the relevant other member of my team to check over my code and ensure it is both working and clearly written, once the PR has been approved the branch would be merged back into master, or more preferrably another branch that has been created perhaps a 'develop' branch or a 'release' branch.

I love git and welcome any questions you have on the topic of version control and open source development.

# Finally
Hopefully you find my solution well and that I have address at least your base requirements

If you have any questions about my approach or decisions I made please contact me and I will be happy to talk you through everything.