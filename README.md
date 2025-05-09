Job-Finding-Portal is a web application that allows users to search for job listings and enables employers to post new job opportunities. The backend is built using Spring Boot and uses MongoDB as the primary NoSQL database.

🔍 Key Features
Job Posting: Employers can create and manage job listings.
Job Search: Users can search for jobs using keyword-based queries.
MongoDB Atlas Search: Full-text search functionality is powered by MongoDB Atlas Search.
Aggregation Pipelines: Custom aggregation pipelines are configured in MongoDB (via Collections → Aggregation) to perform:
Keyword-based search across fields like techs, desc, and profile
Sorting of results based on experience
Limiting the results to the top 3 matches for performance and relevance
