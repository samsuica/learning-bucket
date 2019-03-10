from bookclass import Book
#placeholder for sentences in book class
book1sen = []
book2sen = []
book3sen = []
book4sen = []
book5sen = []

#Starts off book classes
book1 = Book("The Pearl Of Peace",0, "C:/Users/Sam/Desktop/Python/thepearlofpeace.txt", "nothing",book1sen,0)
book2 = Book("The Soul Of Black Folk",0, "C:/Users/Sam/Desktop/Python/thesoulsofblackfolk.txt", "nothing",book2sen,0)
book3 = Book("War And Peace",0, "C:/Users/Sam/Desktop/Python/warandpeace.txt", "nothing",book3sen,0)
book4 = Book("Metamorphosis",0, "C:/Users/Sam/Desktop/Python/metamorphosis.txt", "nothing",book4sen,0)
book5 = Book("Adventures Of Huckleberry Finn",0, "C:/Users/Sam/Desktop/Python/adventuresofhuckleberryfinn.txt", "nothing", book5sen,0)

#creates a library of the book objects
library = [book1,book2,book3,book4,book5]

#builds book class
for book in library:
    with open(book.filename, encoding="utf-8") as file_object:
        book.contents = file_object.read()
         
    book.get_wordcount()
    book.get_sentences()
    
exit = 'n'
#loop that creates menu
while exit != 'y':
    print("Library Project")
    print("1.) Add Book to Library")
    print("2.) See All Books in Library")
    print("3.) Search for Book in Library")
    print("4.) List a Sentence Position in Book")
    print("5.) Search for a Word and Show Sentences that Contain that Word")
    print("6.) Quit")
    menuoption = input("Please Choose an Option: ")
          
    #Adds book to library 
    if menuoption == '1':
        booksen = []
        add_book_title = input("What is the title of the book you would like to add? ").title()
        add_book_filename = input("What is the file path for the book? ")
        
        add_book = Book(add_book_title,0, add_book_filename, "nothing", booksen,0)
        library.append(add_book)
        
        with open(add_book_filename, encoding="utf-8") as file_object:
            add_book.contents = file_object.read()
        
        add_book.get_wordcount()
        add_book.get_sentences()
           
    #See all books in library and it will show book and word count. Intentionally left out contents to make a cleaner output
    if menuoption == '2':
        for book in library:
            print("")
            print(book.title)
            print("\t" + "Word Count: " + str(book.wordcount))
            print("\t" + "File Path: " + book.filename)
            print("")
            
    #Search a book and it will print title and count 
    searching = 'cont'
    if menuoption == '3':
        search = input("Enter the book you would like to search: ").title()
        while searching != 'quit':
           for book in library:
                if book.title == search.title():
                    print("")
                    print("Book found...")
                    print(book.title)
                    print("\t" + "Word Count: " + str(book.wordcount)) 
                    print("\t" + "File Path: " + book.filename)
                    print("")
                    searching = 'quit'
                
           if searching == 'cont':
             print("")
             print("Sorry, your book is not in our library")
             print("")
             searching = 'quit'
                
    #List a sentence position in a book          
    if menuoption == '4':
        searchbook = input("What book would you like to search a sentence in? " ).title()
        searchnum = int(input("What sentence number position would you like to see? "))
                       
        for book in library:
            if searchbook == book.title:
                
                if searchnum <= book.sentencecount:
                    print("")
                    print("Sentence found...")
                    print(book.sentences[searchnum + 1] + ", Sentence #" + str(searchnum))
                    print("")
                                                 
     #Asks for book and word and prints all sentences where the word is in the sentence               
    if menuoption == '5':
        searchbook = input("What book would you like to search a word in? ")
        searchword = input("What word would you like to search for? ")
        
        for book in library:
           if book.title == searchbook.title():
               Book.find_word(book,searchword)
            
    #exits program
    if menuoption == '6':
        print("Goodbye")
        exit = 'y'
     
#prints data to text file
libraryfile = open("Libraryfile.txt","w", encoding="utf-8")

count = 1
libraryfile.write("Format: Book Title\tWord Count\tFile Path\n")
for book in library:
    
    libraryfile.write(str(count) + ".) " + book.title + "\t" + str(book.wordcount) + "\t" + book.filename + "\n")
    count = count + 1
   
libraryfile.close()    

for book in library:
    textfilename = book.title + " Text.txt"
    textfile = open(textfilename,"w", encoding="utf-8")
    for sentence in book.sentences:
        textfile.write(sentence)
       
    textfile.close()


















