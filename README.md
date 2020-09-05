# Application Layer
## Service Layer
- Provides the implementation for the business logic of the application, including such things as business rules, validations, and calculation logic.
Testing
- Our Service layer code is dependent on our DAO/Repository.
- To test the Service layer, we do not need to know or care about how the persistence layer is implemented.
- We should be able to write and test our Service layer code without wiring in our full persistence layer.
- Using mockito to help in the testing process.
### Mockito
- Open-source mocking framework for Java. 
- Is a mocking framework for unit tests in Java.
- It has been designed to be intuitive to use when the test needs mock.
More information:
https://github.com/mockito/mockito
https://github.com/mockito/mockito/wiki
## RESTFul Web Services Layer
- RESTful web services are built to work best on the Web. Representational State Transfer (REST) is an architectural style that specifies constraints, such as the uniform interface, that if applied to a web service induce desirable properties, such as performance, scalability, and modifiability, that enable services to work best on the Web.
- In the REST architecture style, clients and servers exchange representations of resources by using a standardized interface and protocol.

The following principles encourage RESTful applications to be simple, lightweight, and fast:
- Resource identification through URI: A RESTful web service exposes a set of resources that identify the targets of the interaction with its clients. Resources are identified by URIs, which provide a global addressing space for resource and service discovery.
- Uniform interface: Resources are manipulated using a fixed set of four create, read, update, delete operations: PUT, GET, POST, and DELETE. PUT creates a new resource, which can be then deleted by using DELETE. GET retrieves the current state of a resource in some representation. POST transfers a new state onto a resource.
- Self-descriptive messages: Resources are decoupled from their representation so that their content can be accessed in a variety of formats, such as HTML, XML, plain text, PDF, JPEG, JSON, and others. Metadata about the resource is available and used, for example, to control caching, detect transmission errors, negotiate the appropriate representation format, and perform authentication or access control.
- Stateful interactions through hyperlinks: Every interaction with a resource is stateless; that is, request messages are self-contained. Stateful interactions are based on the concept of explicit state transfer. Several techniques exist to exchange states, such as URI rewriting, cookies, and hidden form fields. The state can be embedded in response messages to point to valid future states of the interaction.
### API standard
A good article to cover this information.

- GET /tasks – Retrieves a list of tasks
- GET /tasks/12 – Retrieves a specific task
- POST /tasks – Creates a new task
- PUT /tasks/12 – Updates task #12
- PATCH /tasks/12 – Partially updates tasks #12
- DELETE /tasks/12 – Deletes tasks #12
### Relations
- GET /tasks/12/users – Retrieves list of users for task #12
- GET /tasks/12/users/5 – Retrieves users #5 for task #12
- POST /tasks/12/users – Creates a new users in task #12
- PUT /tasks/12/users/5 – Updates users #5 for task #12
- PATCH /tasks/12/users/5 – Partially updates users #5 for task #12
- DELETE /tasks/12/users/5 – Deletes users #5 for task #12
### Documentation
- An API is only as good as its documentation.
- The docs should be easy to find and publically accessible. Most developers will check out the docs before attempting any integration effort.
### Versioning
- Always version your API.
- Versioning helps you iterate faster and prevents invalid requests from hitting updated endpoints.
- It also helps smooth over any major API version transitions as you can continue to offer old API versions for a period of time.
- The version needs to be in the URL to ensure browser exploitability of the resources across versions.
Example: https://stripe.com/docs/api/versioning
https://api.stripe.com/v1/charges
### Result filtering, sorting & searching

**Filtering:**

Use a unique query parameter for each field that implements filtering. For example, when requesting a list of tasks from the /tasks endpoint, you may want to limit these to only those in the open state.
GET /tasks?priority=medium.

**Sorting:**

A generic parameter sort can be used to describe sorting rules.
GET /tasks?sort=-priority – Retrieves a list of tasks in descending order of priority.

**Searching:**

Basic filters aren’t enough and you need the power of full-text search.
Search queries should be passed straight to the search engine and API output should be in the same format as a normal list result.
Combining these together, we can build queries like:

- GET /tasks?sort=-updated_at – Retrieve recently updated tasks
- GET /tasks?priority=medium&sort=-updated_at – Retrieve recently closed tasks
- GET /tasks?q=return&priority=medium&sort=-priority,created_at – Retrieve the highest priority open tasks mentioning the word ‘return’