class WaterTap:
    name, brand, material, price, quantity, total_quantity = "tap name", "tap brand", "tap material", 0, 0, 0

    def __init__(self, m_name='no name', m_brand='no brand', m_material='iron', m_price=0, m_quantity=10):
        self.name = m_name
        self.brand = m_brand
        self.material = m_material
        self.price = m_price
        self.quantity = m_quantity
        WaterTap.total_quantity += m_quantity

    def to_string(self):
        return 'This water tap of brand ' + self.brand + ' called ' + self.name + ', its body material is ' + \
               self.material + ', its price is $ ' + str(self.price) + ', quantity of this tap is  ' +\
               str(self.quantity) + ' pieces'

    def print_sum(self):
        print('There is  ' + str(self.quantity) + ' of taps, which called ' + self.name + ' , there is '
              + str(self.total_quantity) + ' total number')

    @staticmethod
    def print_total_quantity():
        print('There is ' + str(WaterTap.total_quantity) + ' taps total')


if __name__ == '__main__':
    sanluxVilla = WaterTap()
    hansgrohe = WaterTap("HANSGROHE", "Metric Steel Optic", "brass", 803)
    tangoRio = WaterTap("Tango Rio", "04", "brass", 35, 600)
    print(sanluxVilla.to_string())
    print(hansgrohe.to_string())
    print(tangoRio.to_string())
    WaterTap.print_total_quantity()
    hansgrohe.print_sum()
    tangoRio.print_sum()
