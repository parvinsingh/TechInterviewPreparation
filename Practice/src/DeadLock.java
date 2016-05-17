
public class DeadLock {

	static class Friend {
		private final String frndName;
		
		public Friend(String frnd){
			this.frndName = frnd;
		}
		
		public String getName(){
			return this.frndName;
		}
		
		public synchronized void bow(Friend frnd){
			//TODO- Do something
			frnd.bowBack(this);
		}
		
		public synchronized void bowBack(Friend frnd){
			//TODO- Do Something
		}
	}
	
	public static void main(String args[]){
		final Friend frnd1 = new Friend("Alphonse");
		final Friend frnd2 = new Friend("Alphonse");
		
		new Thread(new Runnable(){
			public void run(){
				frnd1.bow(frnd2);
			}
		}).start();
		
		new Thread(new Runnable(){
			public void run(){
				frnd2.bow(frnd1);
			}
		}).start();
	}
}
