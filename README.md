# OneEcom
OneEcom is Generic Ecommerce Application which will give base to any Ecommerce Application.

### Guidelines (We are/must be strict to)

* Package Name to be start with app.oneecom continued by the library module name:
e.g. app.oneecom.navigation

* All feature modules are packed horizontally and act as an independent entity use load/unload feature of
Android Studio to work on it.

* Navigation between feature module aka Task Redirection is done via: navigation module
* Navigation Module contain Intent using actions. For each activity we define an action...
Sample Action name: action.oneecom.home.open

* Aim is to create 100% kotlin code.
* Single line spacing is enough
* No need of m prefix as IDE is inteligent enoungh to disnguish between local and field variables.

* Reference links to be added with convention "Refer to:" e.g.  <!--Refer to: reference_link_here -->
This is a simple convention used to look for the reference with ease.


### For MVP, What is not included? We are flexible to:
* Tablets configuration: We will work on tablet UI/UX in later release/milestone.

## Acknowledgement / Important Github project / References

* https://github.com/iammert/AndroidArchitecture
* https://github.com/VMadalin/kotlin-sample-app
