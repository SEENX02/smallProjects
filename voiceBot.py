import json
import pyttsx3
import speech_recognition as sr
from difflib import get_close_matches

def get_audio():
	r = sr.Recognizer()
	with sr.Microphone() as source:
		audio = r.listen(source)
		said = ""

		try:
		    said = r.recognize_google(audio)
		    print(said)

		except Exception as e:
		    print("Exception: " + str(e))

	return said

def speak(text):
    engine = pyttsx3.init()
    engine.say(text)
    engine.runAndWait()


# LOADING THE BOT MEMORY IN A JSON FILE
def loadBotMemory(file_path: str) -> dict:

    with open(file_path, 'r') as file:
        data: dict = json.load(file)
    return data

# SAVING THE BOT MEMORY
def saveBotMemory(file_path: str, data: dict):

    with open(file_path, 'w') as file:
        json.dump(data, file, indent=2)

# FINDING THE BEST ANSWER FOR THE USER'S QUESTION
def findBestMatch(user_question: str, questions: list[str]) -> str | None:

    #USING DIFFLIB INBUILT FUNCTION TO MATCH THE USER QUESTION
    matches: list = get_close_matches(user_question, questions, n=2, cutoff=0.8)
    return matches[0] if matches else None

# ACCESSING THE ANSWER FROM THE USER MATCHED QUESTION
def getAnswerForQuestion(question: str, botMemory: dict) -> str | None:

    for q in botMemory["questions"]: # GETTING THE ANSWER FROM THE MATCHES QUESTION
        if q["questions"] == question:
            return q["answer"] # RETURNING THE ANSWER FOR THE USER QUESTION

# DEFINING THE BOT FUNCTION
def voiceBot():

    print("Hello, I am jarvis, How can I help you?")
    speak("Hello, I am jarvis, How can I help you?")

    #CREAING OBJECT TO LOAD JSON FILE
    botMemory: dict = loadBotMemory("VoiceBotMemory.json")

    while True: #INFINITE LOOP UNTIL QUIT
        print("Listening...")
        user_input: str = get_audio()

        if user_input.lower() == "quit":
            speak("Thanks for asking me!")
            break

        if user_input == "":
            print("I cannot hear you!")
            speak("I cannot Hear you!")

            break


        best_match: str | None = findBestMatch(user_input, [q["questions"] for q in botMemory["questions"]])

        if best_match:

            answer: str = getAnswerForQuestion(best_match, botMemory)
            print(f"Bot: {answer}")
            speak(answer)

        else:

            print("Bot: I don't know the answer. Can you teach me?")
            speak("I don't know the answer. Can you teach me?")

            print("if want to move on just say skip : ")
            speak("if want to move on just say skip : ")

            new_answer: str = get_audio()

            if new_answer == "skip":
                speak("Alright!, Lets move on forward!")
                continue

            if new_answer == "":
                speak("I could not get your response!")
                break

            if new_answer.lower() != "skip":

                botMemory["questions"].append({"questions": user_input, "answer": new_answer})
                saveBotMemory("VoiceBotMemory.json", botMemory)

                print("Bot: Thank you! I learned a new response!")
                speak("Bot: Thank you! I learned a new response!")

if __name__ == '__main__':
    voiceBot()
