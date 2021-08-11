# Gitlet Design Document

**Name**: Atmika and Ihsan;

## Classes and Data Structures

### Commit

#### Instance Variables

1. Message - contains the message of a commit
2. Timestamp - time at which a commit was created. Assigned by the constructor
3. Parent - the parent commit of a commit object represented by SHA1 val
4. pointer system that keeps track of versions of blobs 

### Repository

#### Fields

1. CWD - current working directory
2. GITLET_DIR - Hidden Gitlet directory

### Blobs

#### Fields

1. Sha1_val - the sha value of the new blob that is created name
2. Contents - the serialized contents of the file
3. Name 
HashMap<Sha-1, name>

### StagingArea

#### Fields

1. name - sha-1
2. version - most recent version of the file from blobs [represented in the form of sha-value]

## Algorithms

## Persistence

