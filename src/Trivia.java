public class Trivia { //stores the answer



        /**
         * The answer (the name of the celebrity)
         */
        private String answer;

        /**
         * Creates a Celebrity instance with the supplied answer and clue
         * @param answer  the answer (name of celebrity)

         */
        public Trivia(String answer) {
            this.answer = answer;
        }


        /**
         * Supplies the answer for the celebrity.
         * @return
         */
        public String getAnswer() {
            return answer;
        }



        /**
         * Updates the answer to the provided String.
         * @param newAnswer The new answer.
         */
        public void setAnswer(String newAnswer) {
            answer = newAnswer;
        }

        @Override
        public String toString() {
            return "The correct answer is " + answer + ".";
        }

}
