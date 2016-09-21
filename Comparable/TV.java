public interface TV
{
   public void changeChan();
   public void changeVol();
}
//TV should be an interface because TVs have different hardware.
//Some have speakers or the ability to connect to the internet.
//For TVs like this they should be able to inherit the speaker
//class as well as the internetCapability and TV interface