class Book():
    
  def __init__(self, title, wordcount, filename,contents,sentences,sentencecount = 0):
      self.title = title
      self.wordcount = wordcount
      self.filename = filename
      self.contents = contents
      self.sentences = []
      self.sentencecount = sentencecount
         
    #This method gets the word count
  def get_wordcount(self):
     space = " "
     count = 0

     for letter in self.contents:
        if letter == space:
            count = count + 1
            
     self.wordcount = count
            
    #This method adds all the sentences to a list  
  def get_sentences(self):
      
      punc = "?!."
      sentence = ""
      sentences = []
      sentencecount = 0
      
      for letter in self.contents:
          
          if letter in punc:
              sentence = sentence + letter
              sentences.append(sentence)
              sentence = ""
              sentencecount = sentencecount + 1             
          else:
              sentence = sentence + letter   
              
      self.sentences = sentences
      self.sentencecount = sentencecount
              
   #This method finds the searched word in the searched book and prints all the sentences that contain the word
  def find_word(self, searchword):
      for sentence in self.sentences:
          if searchword in sentence:
              print("")
              print("*****************************************************")
              print("")
              print(sentence)
              
      
      
        
     
      
 
         
                
                
            
            
        
        