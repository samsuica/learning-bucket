#Sam Suica
from icecream import Icecream

#Prints Icecream menu
print("Welcome to Sam's Ice Cream Shop! Please view our menu below")
print("-----------------------------------------------------------")
print ("Ice Cream:\tCones:\tTypes of Sprinkles:")
print("Chocolate\tSugar\tRainbow")
print("Mint Chocolate\tCake\tCotton Candy")
print("Vanilla\t\tWaffle\tChocolate")
print("------------------")
print("Scoops: $2.50")
print("Sprinkles: $0.50")


#Creates a list for the order 
total_order = {}



totalbill = 0
count = 0
place_order = input("Would you like to buy icecream? (yes or no): ").lower()
if place_order.lower() == 'yes':
    name = input("Please enter name for the order: ")
    #Creates a loop for placing the order
    while place_order == 'yes':  
        order = Icecream()
       
        #Asks for icream type
        icecream_data = input("What type of icecream would you like? ").lower()
        if icecream_data not in Icecream.icecream_types:
            print("Sorry we do not have that icecream. Please choose from the menu.")
            icecream_data = input("What type of icecream would you like? ").lower()
            order.add_icecream(icecream_data)
                
        else:
            order.add_icecream(icecream_data)
         
        #Asks for cone type
        cone_data = input("What type of cone would you like? ").lower()
        if cone_data not in Icecream.cone_types:
            print("Sorry we do not have those cones. Please choose from the menu.")
            cone_data = input("What type of cone would you like? ").lower()
            order.add_cone(cone_data)
        else:
            order.add_cone(cone_data)
            
        #Asks for sprinkles
        sprinkle_data = input("What type of sprinkles would you like? ").lower()
        if sprinkle_data not in Icecream.sprinkle_types:
            print("Sorry we do not have those sprinkles. Please choose from the menu.")
            sprinkle_data = input("What type of sprinkles would you like? ").lower()
            order.add_sprinkle(sprinkle_data)
        else:
            order.add_sprinkle(sprinkle_data)
                     
        #Asks for scoops
        error = 't'
        while error == 't':
            try:
                scoop_data = int(input("How many scoops would you like? " ))
                order.add_scoops(scoop_data)
                error = 'f'          
            except ValueError:
                print("Please enter a single value of scoops.")
                error = 't'
        
        
        #Adds the attributes from objects class into a library 
        total_order[count] = [order.icecream,order.cone,order.sprinkle,order.scoops]
        
        #Calculates the bill using a method,calc bill returns value
        totalbill = totalbill + Icecream.calc_bill(order)
        
        
        print(Icecream.print_current(order))
       
        #Asks if you want to make another order         
        another = input("Would you like another order? ").lower()
        if another == 'yes':
            count = count + 1            
        else:
            place_order = 'no'
        
 
    print(name.title())
    #PRINT ORDER HERE
    num = 0
    for entry in total_order:
        print("Entry "+str(entry+1))
        for attribute in total_order[entry]:
            print ("\t"+str(attribute))
        
    
        
    print("Total Bill: $"+str(totalbill))   
    print("Thanks for coming to Sam's Icecream shop!")    
else:
    print("Thanks for coming to Sam's Icecream shop!")
       
            
    
    
        


