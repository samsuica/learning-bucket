#Reads in CSV file to a data frame
test_score <- read.csv(file="StudentsPerformance.csv", header = TRUE, sep = ",",stringsAsFactors = FALSE)

#Gets average test score for reduced lunches
underprivledged_readingscore <- mean(test_score[test_score$lunch=="free/reduced",c("reading.score")])
underprivledged_writingscore <- mean(test_score[test_score$lunch=="free/reduced",c("writing.score")])
underprivledged_mathscore <- mean(test_score[test_score$lunch=="free/reduced",c("math.score")])

#Gets average test score for standard lunches
privledged_readingscore <- mean(test_score[test_score$lunch=="standard",c("reading.score")])
privledged_writingscore <- mean(test_score[test_score$lunch=="standard",c("writing.score")])
privledged_mathscore <- mean(test_score[test_score$lunch=="standard",c("math.score")])


#Creates a data frame comparing test scores to set up for bar graph
compare_reading <- c(underprivledged_readingscore,privledged_readingscore)
compare_writing <- c(underprivledged_writingscore,privledged_writingscore)
compare_math <- c(underprivledged_mathscore,privledged_mathscore)

compare <- cbind(compare_reading,compare_writing,compare_math)
compare
colnames(compare) <- c("Reading Score", "Writing Score", "Math Score")
rownames(compare) <- c("Reduced/Free Lunch", "Standard Lunch")
compare

#creates bar plot to show the relationship 
barplot(compare, beside=T,col=c("darkblue","red"), font.axis=2,ylab="Average Test Score",main="Free/Reduced Lunches Vs. Standard Lunch Test Scores", ylim = c(0,100),legend=rownames(compare))
compare


#Counts the levels of parents education for privledge and unprivledge kids
privledgevsparents <- count(test_score, c("parental.level.of.education"))
privledgevsparents

#Creates pie graph that shows  kids parents's education
underslice <- c(222,118,196,59,226,179)
underlbl <- c("associate's degree", "bachelor's degree", "high school", "master's degree","some college","some high school" )
pct <- round(underslice/sum(underslice)*100)
underlbl <- paste(underlbl,pct)
underlbl <- paste(underlbl,"%",sep="")
pie(underslice,labels=underlbl,col=rainbow(length(underlbl)), main = "Kid's Parent's Education")

#Creates pie graph that shows free/reduced lunch kids parents's education
underslice <- c(77,44,70,24,79,61)
underlbl <- c("associate's degree", "bachelor's degree", "high school", "master's degree","some college","some high school" )
pct <- round(underslice/sum(underslice)*100)
underlbl <- paste(underlbl,pct)
underlbl <- paste(underlbl,"%",sep="")
pie(underslice,labels=underlbl,col=rainbow(length(underlbl)), main = "Free/Reduced Lunch Kids Parent's Education")

#Creates pie graph that shows standard lunch kids parents's education
standardslice <- c(145,74,126,35,147,118)
standardlbl <- c("associate's degree", "bachelor's degree", "high school", "master's degree","some college","some high school" )
standardpct <- round(standardslice/sum(standardslice)*100)
standardlbl <- paste(standardlbl,standardpct)
standardlbl <- paste(standardlbl,"%",sep="")
pie(standardslice,labels=standardlbl,col=rainbow(length(standardlbl)), main = "Standard Lunch Kids Parent's Education")

#I added a new column to my data frame called privlege
#I gave them a privledge rating of either high, average, or low based on their parents education and lunch status in school. I did this by using the if statements inside the for loop and quickly did this with the whole data set by using the for loop to do this to every row in the data set. 
for(i in 1:nrow(test_score)){
  
  if((test_score[i,]$parental.level.of.education=="master's degree") && (test_score[i,]$lunch=="standard")){
    test_score[i,]$privledge <- "high"
  }
  
  else if((test_score[i,]$parental.level.of.education=="some high school") && (test_score[i,]$lunch=="free/reduced")){
    test_score[i,]$privledge <- "low"
  }
  else{
    test_score[i,]$privledge <- "average"
  }
}

install.packages('car')  
library(car)

#Makes the 3 levels a privledge factors
test_score$privledge <- factor(test_score$privledge)

#I use this as an example to show that lm is not the best to create my model. I don't want to use this because lm does not work well with categorical data. My p value is 0 which shows there is a difference in the varibales. However, My r squared is 5%. this is because my graph is basically just 3 verticle lines that are different in height, but their values differ alot in them. But each verticle line differs a different amount.
fit2 <- lm(math.score+reading.score+writing.score ~ privledge, data = test_score)
summary(fit2)

#I chose to use aov to view my model because it works better with categorical data. I am trying to figure out if privledge (categorical variable) can determine the students test scores. By using aov, it is a wrapper for lm and helps fits the model for balance and unbalance designs. The p value shown by it is 0, meaning the privledge variabels are different from eachother. 
fit <- aov(math.score+reading.score+writing.score ~ privledge, data = test_score)
summary(fit)



#I create these plots to prove that there is a difference and illustrate why I got a 0 p value but a 5% r squared value. These plots create box and whisker plots and show the difference between the 3 privledge levels for math, reading, and writing scores. As you can see, the averages for each of the privledge are distictly different and so are their upper and lower quartiles. However, their outliners are the same which makes sense considering their are sure to be outliners in test scores with all types of students. It also shows why the r squared value would be 0. If you were to draw a regression line through all of the points on these graphs, many would be far away from the line because the graph would just consist of 3 verticle lines. However, this graph illustratates how the 3 verticle lines would be different. Also, shows why looking at the data as 3 seperate box and whisker plots is more beneficial and illusrates the difference in the privledge variable better.  

plot(test_score$privledge, test_score$math.score, main="Privilege vs. Math Score", xlab = "Privledge", ylab="Math Score", col=c("darkorange","darkred","darkgreen"))

plot(test_score$privledge, test_score$reading.score, main="Privilege vs. Reading Score", xlab = "Privledge", ylab="Reading Score", col=c("darkorange","darkred","darkgreen"))

plot(test_score$privledge, test_score$writing.score, main="Privilege vs. Writing Score", xlab = "Privilege", ylab="Writing Score", col=c("darkorange","darkred","darkgreen"))





#Since Step wise regression was not suitable for my dataset since I only had 3 numeric variables, I choose to make another linear model looking at how the test schools influence eachother. I invetigated how the reading score affects the math score. After running it, I saw that for every 1 percent increase in the math grade, a .8 incease in the reading score. It had an r squared value of 66% and a 0 p value. This would be enough for me to interpret that reading score does affect the math score because more than half of the time an increase in reading score will result in an increase in math score. 
testfit <- lm(math.score ~ reading.score, data = test_score)
summary(testfit)



#I also made clusters to see if my model would correctly classify test scores into the correct privilege level. My model had distinct groups, however, it classified alot of the wrong in the average category. I assume this is because there are a lot of average privileged students and not as many high and low. 


scores_z <- as.data.frame(lapply(test_score[6:7], scale))
test_clusters <- kmeans(scores_z, 3)

test_clusters$size
test_clusters$centers
table(test_clusters$cluster,test_score$privledge)

install.packages("ggplot2")
library(ggplot2)

ggplot(test_score,aes(math.score,reading.score,color = privledge)) + geom_point()














