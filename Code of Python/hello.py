class fc:
    def __init__(self, x, y):
        self.x = x
        self.y = y
    def add(self,obj):
        return fc(self.x+obj.x,self.y+obj.y)
    def printme():
        print "x=",self.x,"y=",self.y
    