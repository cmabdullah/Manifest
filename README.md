## How is the coordination between different nodes done?
Each BackgroundJobServer registers itself on startup in the StorageProvider. 
For an RDBMS, this is a plain old table called jobrunr_backgroundjobservers. 
The master is the server which is the longest running (so, the one that was registered as first node).
Then, every 15 seconds, each BackgroundJobServer updates a lastHeartBeat timestamp. 
If a node crashes for some reason (this can also be the master node), the lastHeartBeat timestamp is not updated anymore. 
All other server participating in processing jobs see that the master node is not active anymore and it is removed from the StorageProvider.
Next, the master reelection process starts which is again nothing more than the longest running BackgroundJobServer.

## What is the role of the master?
The master is a BackgroundJobServer like all other nodes processing but it does some extra tasks:

- it checks for recurring jobs and schedules them when they are about to run
- it checks for scheduled jobs and enqueues them when they need to run
- it checks for orphaned jobs and reschedules them
- it does some zookeeping like deleting all the succeeded jobs
