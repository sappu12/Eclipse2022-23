
Overview:
Gaming Hub, a place where user can play puzzles, create puzzles. Here there is another group called admins who can manage players, and puzzles execute reports and process feedback.
This is an end-to-end enterprise level application.

This application has 3 roles:
Admin: At the time of registration if system couldn't find any admin will be registered as admin and has full ability to control the whole application.
Player : By default every person who registers will be considered as players. Players has ability to play play free games which are set by the admin in business rules.
Creator: to be a creator one should send a request to admin to make as creator via feedback form. A creator can play unlimited games as well as he can crete new puzzles to play which will be picked randomly to play to playes.

Player can play only limited number of puzzles which is set by admin and if want to play more can raise a request to move as Prime-Member via feedback.

Prime Membership advantages: play unlimited games.
                             can play tournments (which is implemented in version-2).
                             
Creator can have ability to create puzzles and also can play unlimited games. He can be primemember or not.
Creator can manage puzzles the one which he created can update/delete (implement in v-2).

Player when start a puzzle to play his/her time will be considered as start time for the puzzle untill he submits the puzzle the end time considered.
The puzzle which is randomly picked will be displayed untill he either submits/resign from that. he can go to other links but time is calculated/considered.

Wins/loses will be count as per the result. If he resigns the game will be considered as play and quit.(counted in number of free games).

Players can get awards/ratings based on the play time puzzles (implement in version-2).

Admin who can control the full application and can set business rules like : number of free games to play and tournment mode(implemented in v-2).
Reports:
He can generate reports like: top players (calculated based on number of wins and time spent)
                              puzzle Statistics ( which puzzle is mostly picked to play and max number of wins/loses)
                              
He can manage operators who are registered (can change/update info and also can update roles(creator/palyer) and can set prime membership to users.
He can manage feedback the requests came in to change roles /or any feedback can be viewed and proccessed.
Admin can also manage puzzles which are created by admin/creators .(implement in v-2).

Game Modes:
            Standard/Play mode : If admin sets this users can play puzzles untill free games count hit.(non-prime members)
                                 Prime members can play unlimited puzzles in this mode.
            Tournment Mode: If admin sets this only prime members can play the puzzles as a tournment (implemented in v-2).
            
 Scope:
 Currently my gaming hub supports only sudoku puzzle (working on chess puzzles in v-2).
 Future can incorporate many puzzles and any type.
 Prime membershio benefits added.
 
 Assumptions:
    Creator will create a valid puzzle which will have both possible outcomes.
    Admin wont forget his paasword.(forget password/reset password implemented in v-2).
 
 Tools/Technologies used:
                        1. Spring , Spring boot, Spring security, Hibernate, Spring data JPA,Lombok
                        2. Mysql database (back end)
                        3. Thymeleaf , bootstrap (front end).
                        
                        
 Use-Cases:
                  Sudoku:

                      Brain training: Sudoku puzzles are great for improving cognitive function and memory. Playing Sudoku puzzles regularly can help improve mental agility and overall brain health.

                      Relaxation: Many people find solving Sudoku puzzles to be a relaxing and stress-relieving activity. Sudoku puzzles can be a great way to unwind after a long day or during a break from work.

                      Education: Sudoku puzzles can be used in schools and educational settings to teach critical thinking and problem-solving skills. Teachers can use Sudoku puzzles to help students develop logical reasoning and mathematical skills.

                      Rehabilitation: Sudoku puzzles can be used as part of rehabilitation programs for patients recovering from injuries or illnesses. Sudoku puzzles can help improve hand-eye coordination, concentration, and cognitive function.

                  Chess:

                      Mental health: Chess puzzles can be used to promote mental health and improve cognitive function. Playing chess can help improve memory, concentration, and problem-solving skills.

                      Education: Chess puzzles can be used in schools and educational settings to teach critical thinking and strategy. Chess can help students develop logical reasoning and problem-solving skills.

                      Competitions: Chess puzzles can be used as part of chess competitions to challenge players and improve their skills. Chess puzzles can be used to set up training scenarios or to test a player's ability to find the best move.

                      Entertainment: Chess puzzles can be used for entertainment purposes to provide a challenging and engaging activity for players. Many chess players enjoy solving puzzles as a way to improve their skills and pass the time.
            
