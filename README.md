LittleLingo Application
1. Behnaz Khalili (Leader)
2. Shadan Farahbakhshdarabi
3. Kawthar Mashkour
1. INTRODUCTION
Welcome to our English Learning App for Children!
Motivation Sentence:
In today's globalized world, English proficiency is an essential skill for academic success and future career opportunities.
Problem Statement:
Many children struggle with traditional methods of learning English vocabulary and grammar, finding them dull and ineffective. This lack of engagement hampers their progress and reduces their motivation to learn.
Proposed Solution:
Our app offers an interactive and immersive learning experience designed specifically for children. It features engaging vocabulary and grammar lessons, audio support for better pronunciation, and quizzes to test and reinforce learning. The result report feature allows parents and teachers to track the child's progress and identify areas needing improvement. The app engages children through the use of captivating images, audio, and video.
2. MOTIVATION
Background of the Problem:
English is a global language, and proficiency in it opens up numerous opportunities for children. However, traditional methods of teaching English often fail to engage young learners, leading to poor retention and understanding.
Why This Problem is Interesting:
The challenge of making language learning engaging and effective for children is a critical one. Finding a solution that keeps children interested while also providing solid educational value can have a significant impact on their future success.
When and Why the Problem Occurs:
The problem occurs in traditional classroom settings and through conventional learning materials, which may not cater to the interactive and playful nature of children. This results in a lack of engagement and slower learning progress.
Current State of Solutions:
There are existing educational apps and resources aimed at teaching English to children. However, many of these solutions either lack interactivity or do not provide comprehensive coverage of both vocabulary and grammar.
Improvements Our App Makes:
Our app combines interactive lessons with engaging audio support and quizzes, making learning fun and effective. The result report feature is an added advantage, allowing for better tracking of progress and targeted improvements. This holistic approach sets our app apart from existing solutions by addressing both engagement and educational effectiveness.
3. ENVIRONMENT Hardware Requirements:
• Development: A computer with a minimum of 8GB RAM and a multi-core processor for developing and compiling the app.
• Running the App: A smartphone or tablet with Android operating systems. Software Requirements:
• Development:
o Integrated Development Environment (IDE) like Android Studio or
IntelliJ.
o Programming languages: Kotlin for Android.
o Libraries and frameworks: XML
o Audio and Video processing libraries for handling the pronunciation
feature.
o Testing frameworks for unit and UI testing.
• Running the App:
o Latest versions of Android.
o Internet connection for downloading the app and accessing online
features.
• Testing:
o Emulators for different Android .

o Automated testing tools to simulate various user interactions and scenarios.
REQUIREMENTS
Meeting the Requirements:
Our app is designed to comprehensively meet all the mentioned requirements:
• Interactive and Immersive Learning Experience:
o The app provides engaging vocabulary and grammar lessons tailored
for children. Interactive elements such as images, audio, and video
make learning enjoyable and effective.
• Audio Support:
o The vocabulary section features audio support, helping children learn
correct pronunciations. This audio support is integrated seamlessly to
ensure that children can easily listen and repeat words.
• Quizzes:
o The app includes quizzes for both vocabulary and grammar. These
quizzes are designed to be fun and challenging, reinforcing the lessons
and helping children retain what they have learned.
• Result Reports:
o The result report feature tracks the child's progress, showing quiz
results and highlighting areas needing improvement. This feature is beneficial for both parents and teachers to monitor and support the child's learning journey.
Unmet Requirements:
o Using API for getting vocabulary and audios
o Adding face detection part for child
o A feedback mechanism within the app allows users to report issues or
suggest
SDLC model:
We have chosen the Agile SDLC model for the development of our app due to its flexibility and adaptability, allowing for iterative development based on user feedback and changing requirements. Agile breaks the development process into smaller, manageable increments, ensuring that functional parts of the app are delivered quickly and efficiently. This user-centric approach emphasizes

collaboration with parents, teachers, and children, ensuring the app meets their needs and expectations. Additionally, Agile promotes continuous testing and integration, allowing us to identify and fix issues early, resulting in a robust and reliable final product.
The phases of Agile in our development include planning, designing, developing, testing, reviewing, and deploying the app. During the planning phase, we define the scope, objectives, and requirements, prioritizing features and creating a product backlog. In the design phase, we develop initial prototypes and gather feedback from users and stakeholders. The development phase involves implementing features in small increments with continuous testing and integration. Testing includes unit, integration, and user acceptance testing, with any issues being promptly addressed. The review phase involves regular progress reviews and adjustments based on feedback. Finally, the deployment phase releases the app incrementally, starting with a minimum viable product (MVP) and continuously updating it based on user feedback.
![Blank diagram (1)](https://github.com/behnazkhalili84/EnglishTraining/assets/89276106/58f28fe5-8141-4660-b6dd-f0e542f8413a)
Screen shot on phone
![Screenshot 2024-06-15 at 7 43 20 PM](https://github.com/behnazkhalili84/EnglishTraining/assets/89276106/87496531-edc2-496a-85d5-e22d603e039c)
![Screenshot 2024-06-15 at 7 43 31 PM](https://github.com/behnazkhalili84/EnglishTraining/assets/89276106/65a89944-d930-476a-ab54-350e40669840)
![Screenshot 2024-06-15 at 7 38 53 PM](https://github.com/behnazkhalili84/EnglishTraining/assets/89276106/349a0470-742c-4163-b0e2-8bed1524a6ec)
![Screenshot_20240616_210231_EnglishTraining](https://github.com/behnazkhalili84/EnglishTraining/assets/89276106/2d964566-c576-46cc-af0a-8e3af5e01968)
![Screenshot_20240616_210225_EnglishTraining](https://github.com/behnazkhalili84/EnglishTraining/assets/89276106/cd037d0c-b678-4618-8746-dca4292c9e3b)
![Screenshot_20240616_210143_EnglishTraining](https://github.com/behnazkhalili84/EnglishTraining/assets/89276106/18809bc0-fd87-42b5-a617-cfcf885944ba)
![Screenshot_20240616_210044_EnglishTraining](https://github.com/behnazkhalili84/EnglishTraining/assets/89276106/2c8cd4a2-c339-464c-982f-c3b63926480c)
![Screenshot_20240616_205918_EnglishTraining](https://github.com/behnazkhalili84/EnglishTraining/assets/89276106/dd6de0d2-484d-4027-9179-0cc134019a7d)
![Screenshot_20240616_205913_EnglishTraining](https://github.com/behnazkhalili84/EnglishTraining/assets/89276106/6a40cb3a-028f-49e2-9dbc-5261c8d28bb2)
![Screenshot_20240616_205852_EnglishTraining](https://github.com/behnazkhalili84/EnglishTraining/assets/89276106/781337a7-ce75-48ae-8008-2d9989f10b2f)
![Screenshot_20240616_211008_EnglishTraining](https://github.com/behnazkhalili84/EnglishTraining/assets/89276106/50abeb7f-a1a8-4de1-a43d-69737e3b045a)
The User Fragment is the first fragment that implements user sign-in. For implementation, we used SQLite to save user information in a user table with user_id as the primary key. We support CRUD operations on user accounts and provide authentication for users. After signing in, users are redirected to the Home Fragment, which features a menu with options for Learning Vocabulary, Learning Grammar, Vocabulary Quiz, Grammar Quiz, and Quiz Report.
In the Learning Vocabulary section, each lesson includes 8 vocabulary words with accompanying audio for better pronunciation. Similarly, in the Learning Grammar section, each lesson includes 8 grammar elements, each with its audio.
The Quiz section consists of 8 questions per quiz. We calculate the number of correct answers and notify the user upon completion of the quiz. The quiz information, including Quiz Type (Vocabulary/Grammar), user_id, total questions, number of correct answers, and quiz date, is saved in the database.
The Quiz Report section retrieves the user's quiz information and displays it to the user, allowing them to review their performance.

6. Use case diagram:
   <img width="468" alt="image" src="https://github.com/behnazkhalili84/EnglishTraining/assets/89276106/d9037b1d-16ae-4a58-9deb-8d3bc66968cb">
7. PARTICIPATION PART:
Behnaz: Creating quiz vocabulary, quiz grammar , result report pages and save and retrieve result information to database, implementing JUint testing
Shadan: Creating learning vocabulary and learning grammar pages, implementing audio and video playing
Kawthar: Creating Login process ,profile and CRUD on it .password authorization and home page and add user information to database, and calendar. Some UI was done using material design.

8. ACKNOWLEDGMENTS:
I would like to extend my heartfelt thanks to my teacher(MR.ELIE) for their guidance and support throughout this project. Their valuable insights and encouragement have been instrumental in the successful completion of this app. Thank you for your dedication and for inspiring me to achieve my best.
