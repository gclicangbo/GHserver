package controlthread;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import service.TotalService;
import service.TotalServiceImpl;
public class Control {
	private ServerSocket server;
	private ExecutorService es;
	private TotalService ts;
	public static final int PORT=6666;
	public Control() {
		System.out.println("服务器正在开启");
			try {
				for (int i = 0; i < 5; i++) {
					System.out.print(".");
					Thread.sleep(800);
				}
				System.out.println();
				System.out.println("服务器已开启");
				es=Executors.newCachedThreadPool();
				this.server=new ServerSocket(PORT);
				this.ts=new TotalServiceImpl();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	public void start(){
		while(true){
			try {
				Socket client = this.server.accept();
				System.out.println("用户"+client.getInetAddress().getHostAddress()+"已连接");
				ControlThread ct=new ControlThread(client,ts);
				//把线程交给线程池处理
				es.submit(ct);
				//返回当前活跃人数
				int count = ((ThreadPoolExecutor)es).getActiveCount();
				System.out.println("当前活跃人数是"+count);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				
			}
		}
	}
	
}
