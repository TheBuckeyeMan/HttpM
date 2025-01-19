# HttpM Testing Details

## Required Testing Dependencies 
- mockito-core version: 5.5.0
- mockwebserver version: 4.11.0
- junit-jupiter version: 5.10.0


# Testing

## Working Requirements
Before we push code to Github, We require that code is covered 70%. All unit tests need to be conducted before we push code to github

## Testing Annotations
1. @Mock: Allows you to mock an object that is included in the class we are testing
    - Used to simulate behavior of dependencies in isolation
2. @InjectMocks: Allows you to inject all of the mocked objects to the class we are looking to inject to
    - Used to test a class that relies on mocked dependencies
3. @BeforeEach: Allows us to set up or initialize resources before each test
    - runs before each of the @Test annotations
4. @Spy:Allows us to create a partial mock that uses the real obhjects method unless overwritten
    - Use to test a class while only mocking specific methods
    - Ex. `@Spy`
          `private someClass realObject`
5. @Test: Marks the method as a test case
    - Use it on methods we need to test in the host object
6. @AfterEach: Allows us to clean up resources after each test
    - runs after each @Test annotation
7. @BeforeAll: Allows us to perform expensive, one time setup(Ex. For a database) - Method must be static
    - Runs one time before @Test annotation
8. @AfterAll: Allows us to perform expensive, one time teardown after all tests are complete - Method must be static
    - Runs one time after all @Test annotation shave completed
9. @Disabled: Allows us to disable a @Test annotation so it does not run. Place above the @Test annotation when needed
    - Use only if we need to temporarily disable a test
10. @DisplayName: Allows us to create a custom name for each test method to provide context to each test
    - Syntax @DisplayName("Test to test if the API Was successful) to be placed above the @Test annotation
11. @Nested: Groups all related tests within a single class
    - Use to logically group tests for better organization and readability
12. @Tag: Assigns a tag for each test for filtering purposes
    - Syntax @Tag("Tag here") and we need to place above @Test
13. @ParameterizedTest: Allows us to run the same test with different values. used in combination with @ValueSource(ints = {1,5,2})
    - Place @ParameterizedTest above the @ValueSource tag
14. @RepeatedTest: alows us to repeat the test multiple times
    - Syntax: @RepeatedTest(x)
15. @TestConfiguration: Allows us to define additional test-specific beans
    - Use when we override or define beans in the test context


# Testing notes

WHat is unit testing: 
how would you test if someones blatter is working?
monitor them and check the output
in progrmaing its the same

in programing we take our function, we put something into it, then we se the outputs
We do this for all of the code in our codebase

If we test each line we can assume that we will prevent bugs from occuring.

Thats why its important

### Start Testing
We start with testing repository level
Only we need to test things that ar eprone to breaking and we really only need to test code that needs to bve tested


### Sain - Arragnge, Act, Assert(Tripple A) 
this is how we arrange our tests
#### Arragne
Where we actually go and get the jar of water(Blatter example) this is what we are Inserting into the function we are looking to test
**Insert this code to what we want to test

#### Act 
this is where we are going to test the code. In his example, this is the person(We put the water into the body)

#### Assert
Did the code return as expected? in his example, we check if a persons blatter is working, so we are chekcing if a person is peeing.