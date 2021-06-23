public class CalcSPSwitch{
    {
        float mp=1000.55f,sp;
        char cat='C';
        switch(cat){
            case 'A':
                sp=mp-(mp*60/100);
                break;
            case 'B':
                sp=mp-(mp*40/100);
                break;
            case 'C':
                sp=mp-(mp*20/100);
                break;
            case 'D':
                sp=mp-(mp*10/100);
                break;
            default:
                sp=mp;
                break;
        }
        System.out.println("Selling price is "+sp);
    }
}