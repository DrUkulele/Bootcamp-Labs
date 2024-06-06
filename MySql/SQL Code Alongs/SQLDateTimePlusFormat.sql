#Get current date and time
Select Current_Date() As TodayDate, Current_Time As NowTime;

#Year, Month, Day, Hour, Minute, Second
#Take the year from a date
Select Year(OrderDate)
From Orders;

Select Year(current_date),
	   Month(current_date),
	   Day(Current_date);
       
#All orders that were ordered befor 1997
Select *
From orders
Where year(OrderDate) < 1997;

Select 
DayOfWeek(Current_Date) As DayOfWeek,
DayOfMonth(Current_Date) As DayOfMonth,
DayOfYear(Current_Date) As DayOfYear;

#Formatting dates
Select
Date_Format(Current_Date, '%d-%m-%Y') As EuropeFormat, 
Date_Format(Current_Date, '%m-%d-%y') As UsFormat;

Select DayName(Current_Date) As  DayOfWeek;

#Date arithmetic
#Adding time to a date
#Takes 2 arguments, Time you are starting with, How much time you want to add
Select Date_Add(Current_Date, Interval 7 Week) As OneWeekFromToday;
Select Date_Sub(Current_Date, Interval 7 Day) AS OneWeekAgo;

#Time inbetween 2 dates
Select DateDiff('2024-01-05', '2023-12-31') As DayDiffrence;

#How long does it take for a order to be shipped on Average
Select Avg(DateDiff(ShippedDate, OrderDate)) as AvgShipTime
From orders;


Set time_zone = 'America/Chicago';

Select
Now() As CurrentLocalTime,
Convert_TZ(Now(), @@session.time_zone, 'UTC'); 




