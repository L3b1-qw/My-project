
import calendar
import datetime

#เมนูอาหาร

food=["หมูสไลด์","สันนอกหมู","สามชั้น","หมูพริกไทยดำ","กุ้ง","ปลาดอลลี่","อกไก่","ไข่","หมี่หยก","วุ้นเส้น","มาม่า","ผักบุ้ง"]
foodlow=["หมูสไลด์","สันนอกหมู","สามชั้น","หมูพริกไทยดำ","อกไก่","ไข่","หมี่หยก","วุ้นเส้น","มาม่า","ผักบุ้ง"]
food1=[]
soup=["น้ำดำ","น้ำใส","น้ำต้มยำ","น้ำซุปหมาล่า","ต้มข่า"]
soup2=[]
drink = ["โค้ก","น้ำเปล่า","น้ำส้ม","ชามะนาว","ชานม","ชาไทย","น้ำเขียว","น้ำแดง"]
drink1=[]
Alacart = {"เครปเย็น": 30 , "ฮันนี้โทสต์": 45, "เฟรนช์โทสต์": 25 ,"ครอฟเฟิล" : 30,"วาฟเฟิล" :45,"ชีสเค้ก" :65,}
Alacart1 = set()



#อาหาร
def menu():
    order=1
    i=0
    if press1 == 259 :
        print ("--------menu--------")
        print (list(food))
        while order!="end" :
            order=(input("เลือกอาหาร :"))
            if order not in food:
                if order=="end":
                    break
                if order == "del" :
                    print(food1)
                    order = food1.pop()
                    print(food1)
                else:
                    print ("-------ไม่พบอาหารที่คุณสั่ง-------")
            else:
                food1.append(order)
                print (food1)
                i+=1
    if press1 == 215 :
        print ("--------menu--------")
        print (list(foodlow))
        order=1
        while order!="end" :
            order=(input("เลือกอาหาร :"))
            if order not in food:
                if order=="end":
                    break
                if order == "del" :
                    print(food1)
                    order = food1.pop()
                    print(food1)
                else:
                   print ("-------ไม่พบอาหารที่คุณสั่ง-------")
            else:
                food1.append(order)
                print (food1)
                i+=1
    print ("รายการอาหารที่คุณสั่ง ทั้งหมด",i,"รายการ","\n",food1)
    YesorNo()




#น้ำซุป
def soup1():
    print ("--------menu--------")
    print (list(soup))
    order1=1
    i=0
    while order1!="end" :
        print("หากต้องการลบรายการล่าสุดพิมพ์ --del--")
        order1= (input("เลือกน้ำซุป :"))
        if order1 not in soup:
            if order1=="end":
                break
            if order1 == "del" :
                print(soup2)
                order1 = soup2.pop()
                print(soup2)
            else :
                print ("-------ไม่พบอาหารที่คุณสั่ง-------")
        else:
            soup2.append(order1)
            print (soup2)
            i+=1
    print ("รายการอาหารที่คุณสั่ง ทั้งหมด",i,"รายการ","\n",soup2)
    YesorNo1()



#น้ำดื่ม
def water():
    print ("--------menu--------")
    print (list(drink))
    order2=1
    i=0
    while order2!="end":
        order2=(input("เลือกน้ำ :"))
        if order2 not in drink:
            if order2=="end":
                break
            if order2 == "del" :
                    print(drink1)
                    order2 = drink1.pop()
                    print(drink1)
            else:
                print ("-------ไม่พบอาหารที่คุณสั่ง-------")
        else:
            drink1.append(order2)
            print (drink1)
            i+=1 
    print ("รายการอาหารที่คุณสั่ง ทั้งหมด",i,"รายการ","\n",drink1)
    YesorNo2 ()


#เมนูของหวาน    
def dessert(price):
    print ("--------menu--------")
    print (Alacart)
    i=0
    order3=1
    while order3!="end":
        order3=(input("เลือกของหวาน :"))
        if order3 not in Alacart.keys():
            if order3=="end":
                break
            if order3 == "del" :
                    print(Alacart1)
                    delete = int(input("เลือกรายการที่ต้องการลบ"))
                    Alacart1[Alacart]=int(input("เลือก"(delete)))
                    print(Alacart1)
            else:
                print ("-------ไม่พบอาหารที่คุณสั่ง-------")
        else:
            Alacart1.add(order3)
            price+=Alacart[order3]
            i+=1
    print ("รายการอาหารที่คุณสั่ง ทั้งหมด",i,"รายการ","\n",Alacart1)
    print (price)
    YesorNo3(price)
    return price

#ชำระบิล    
def total(price) :
    while True:
        try:
            print("------เซตที่ท่านเลือก : ",press1,"----------")
            show_enroll()
            total = press1+price
            print ("ยอดรวมที่ต้องจ่าย ",total)
            money = 0
            while money < total :
                money = int(input("กรุณาจ่ายตัง : "))
                print ("รับจำนวนเงินมา",money,"บาท")
                print ("ค่าชำระไม่พอ")
            remain = money-total
            print ("รับจำนวนเงินมา",money,"บาท")
            print("เงินทอน =", remain,"บาท")
            print("*************Thank youuu*****************")
            exit()
        except ValueError:
            print ("\n \n -------กรุณากรอกตัวเลข-------")

        
#รายการเมนู
def mainmenu1 (price):
    print("\n****เมนูหลัก*****")
    print ("0. ออกจากเมนู")
    print ("1. เลิอกเมนูอาหาร")
    print ("2. เลือกน้ำซุป")
    print ("3. เลือกน้ำดื่ม")
    print ("4. จ่ายตัง")
    print ("5. เมนูของหวาน")
    while press1!=0:
        try:
            press=int(input("โปรดเลือกเมนูของท่าน :"))
            if press==1:
                menu()
            elif press==2:
                soup1()
            elif press==3:
                water()
            elif press==4:
                total(price)
            elif press==5:
                price=dessert(price)
            elif press==0:
                print("**ขอบคุณที่บริการ**")
                exit()
            else:
                print ("\n *****กรุณาใส่ใหม่ไม่มีเมนูที่ท่านเลือก******") 
                mainmenu1()
        except ValueError :
            print("\n \n --------กรุณาใส่เลข--------")

#เวลา
def hello_today():
    thisday=datetime.datetime.today().weekday()
    thisday=calendar.day_name[thisday]
    print("*****Hello",thisday,"*****")

#Yesno1
def YesorNo():
    x=1
    while x!=0:
        press12=str(input("\n ท่านต้องการทำรายการต่อหรือไม่(Y/N) \n ถ้ากด Y จะไปหน้าต่อไป \n ถ้ากด N จะไปกลับหน้าเมนูหลัก :"))
        if press12=="Y":
            x=0
            soup1 ()
        if press12=="y":
            x=0
            soup1 ()
        if press12=="N":
            x=0
            mainmenu1(price)
        if press12=="n":
            x=0
            mainmenu1(price)     
        else:
            print ("\n \n --------กรุณาใส่ Y หรือ y / N หรือ n--------")
            x=1
        
    
#Yesno2
def YesorNo1():
    x=1
    while x!=0:
        press12=str(input("\n ท่านต้องการทำรายการต่อหรือไม่(Y/N) \n ถ้ากด Y จะไปหน้าต่อไป \n ถ้ากด N จะไปกลับหน้าเมนูหลัก :"))
        if press12=="Y":
            x=0
            water ()
        if press12=="y":
            x=0
            water ()
        if press12=="N":
            x=0
            mainmenu1(price)
        if press12=="n":
            x=0
            mainmenu1(price)      
        else:
            print ("\n \n --------กรุณาใส่ Y หรือ y / N หรือ n--------")
            x=1

#Yesno3
def YesorNo2():
    x=1
    while x!=0:
        press12=str(input("\n ท่านต้องการทำรายการต่อหรือไม่(Y/N) \n ถ้ากด Y จะไปหน้าต่อไป \n ถ้ากด N จะไปกลับหน้าเมนูหลัก :"))
        if press12=="Y":
            x=0
            dessert (price)
        if press12=="y":
            x=0
            dessert (price)
        if press12=="N":
            x=0
            mainmenu1(price)
        if press12=="n":
            x=0
            mainmenu1(price)      
        else:
            print ("\n \n --------กรุณาใส่ Y หรือ y / N หรือ n--------")
            x=1

#Yesno4
def YesorNo3(price):
    x=1
    while x!=0:
        press12=str(input("\n ท่านต้องการทำรายการต่อหรือไม่(Y/N) \n ถ้ากด Y จะไปหน้าต่อไป \n ถ้ากด N จะไปกลับหน้าเมนูหลัก :"))
        if press12=="Y":
            x=0
            total (price)
        if press12=="y":
            x=0
            total (price)
        if press12=="N":
            x=0
            mainmenu1(price)
        if press12=="n":
            x=0
            mainmenu1(price)     
        else:
            print ("\n \n --------กรุณาใส่ Y หรือ y / N หรือ n--------")
            x=1


def show_enroll():
    j=0
    for order in food1 :
        j+=1
        print ("-----รายการอาหาร-----")
        print(j,".",order)
    for order1 in soup2 :
        j+=1
        print ("-----รายการน้ำซุป-----")
        print(j,".",order1)
    for order2 in drink1 :
        j+=1
        print ("-----รายการน้ำดื่ม----")
        print(j,".",order2)
    for order3 in Alacart1:
        j+=1
        print ("-----รายการของหวาน----")
        print(j,".",order3)
        


    

#เมนูหลัก
print ("-----ยินดีต้อนรับสู่ร้าน-----")
print ("\n------ร้านคุณอ่าวจวยอุทร------")
hello_today()
print ("\n******เมนูรายการของร้านเรา******")
print ("1.บุฟเฟต์ 215 มีหมูกับเนื้อรวมน้ำ")
print ("2.บุฟเฟต์ 259 มีหมูกับเนื้อและอาหารทะเลรวมน้ำ")

#mainmenu program
price=0
x=1
name=str(input("กรุณากรอกชื่อของท่าน : "))
print ("\n \n -------สวัสดีคุณ",name,"-------")
while x!=0:
    try :
        press1=int(input("เลือกบุฟเฟต์ราคาที่ท่านต้องการ :"))
        if press1==215:
            mainmenu1(price)
            x=0
        elif press1==259:
            x=0
            mainmenu1(price)
        else:
            print ("\n------กรุณากรอกใหม่-------")
            x=1
    except ValueError :
        print("\n \n --------กรุณาใส่เลข--------")

