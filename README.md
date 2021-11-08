A scheduled bean adds every x time a new status to the database (See ScheduledService)
.The status is defined in the property "status" in application.yml.

There are 3 integration tests:
* A_WithoutPropertyTest, which is a "normal" integration test that does not override the status property
* B_WithPropertyTest, which overrides the property status. Spring needs to reboot its context to reflect this property change
* C_WithoutPropertyTest, reverting back to the normal situation. If B runs before C, Spring needs to reboot its context to undo the property change.

When any test runs on its own, no problems occur. When tests run after each other and the context gets restarted, you'll see that 2 scheduled methods are adding status to the database: the "normal" status and the overriden status from test B.

Simplified logs:
```
Starting test A
I'm com.example.demo.ScheduledService@737ff5c4 and I'm adding status A
I'm com.example.demo.ScheduledService@737ff5c4 and I'm adding status A
I'm com.example.demo.ScheduledService@737ff5c4 and I'm adding status A
I'm com.example.demo.ScheduledService@737ff5c4 and I'm adding status A
I'm com.example.demo.ScheduledService@737ff5c4 and I'm adding status A
I'm com.example.demo.ScheduledService@737ff5c4 and I'm adding status A
I'm com.example.demo.ScheduledService@737ff5c4 and I'm adding status A

Starting test B
I'm com.example.demo.ScheduledService@737ff5c4 and I'm adding status A
I'm com.example.demo.ScheduledService@4a773f08 and I'm adding status B
I'm com.example.demo.ScheduledService@737ff5c4 and I'm adding status A
I'm com.example.demo.ScheduledService@4a773f08 and I'm adding status B
I'm com.example.demo.ScheduledService@737ff5c4 and I'm adding status A
I'm com.example.demo.ScheduledService@4a773f08 and I'm adding status B
I'm com.example.demo.ScheduledService@737ff5c4 and I'm adding status A
I'm com.example.demo.ScheduledService@4a773f08 and I'm adding status B

String test C
I'm com.example.demo.ScheduledService@737ff5c4 and I'm adding status A
I'm com.example.demo.ScheduledService@4a773f08 and I'm adding status B
I'm com.example.demo.ScheduledService@737ff5c4 and I'm adding status A
I'm com.example.demo.ScheduledService@4a773f08 and I'm adding status B
I'm com.example.demo.ScheduledService@737ff5c4 and I'm adding status A
I'm com.example.demo.ScheduledService@4a773f08 and I'm adding status B
I'm com.example.demo.ScheduledService@737ff5c4 and I'm adding status A
I'm com.example.demo.ScheduledService@4a773f08 and I'm adding status B
```
