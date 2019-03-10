#Sam Suica

class Icecream():
    icecream_types = ["chocolate","mint chocolate","vanilla"]
    cone_types = ["waffle","cake","sugar"]
    sprinkle_types = ["rainbow","cotton candy","chocolate", "none"]
    
    #initiates the variable
    def __init__(self,icecream='chocolate',cone='waffle',sprinkle='rainbow',scoops=2,sprinkle_cost = .5,scoop_cost = 2.5,total_cost = 3):
        self.icecream = icecream
        self.cone = cone
        self.sprinkle = sprinkle
        self.scoops = 2
        self.sprinkle_cost = .5
        self.scoop_cost = 2.5
        self.total_cost = 3
     
    #sets up the icecream object for order 
    def add_icecream(self, new_icecream='chocolate'):
        self.icecream = new_icecream
        
    def add_cone(self,new_cone='waffle'):
        self.cone = new_cone
        
    def add_sprinkle(self,new_sprinkle='rainbow'):
        self.sprinkle = new_sprinkle
        
    def add_scoops(self,new_scoops=2):
        self.scoops = new_scoops
       
        
    #Calculates bills
    def calc_bill(self):
        if self.sprinkle != 'none':
            self.sprinkle_cost = .5
        else:
            self.sprinkle_cost = 0
            
        self.scoop_cost = self.scoops * 2.5
        
        self.total_cost = self.scoop_cost + self.sprinkle_cost
        return self.total_cost
       
    #print method
    def print_current(self):
        return("Your entry is: "+"\n"+"\t"+self.icecream.title()+" icecream, "+self.cone.title()+" cone"+", "+self.sprinkle.title()+" sprinkles"+", "+str(self.scoops)+" scoops")
        
        
        
        
        
        
        


