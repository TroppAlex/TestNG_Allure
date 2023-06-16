package Base;


//import kernel.core.logger.additional.Utils.CleanType;
//import kernel.core.logger.engine.LogHelper;

/**
 * Service class for timer pauses Start timer and returning state of time out.
 *
 * @author Alex Zaveruha
 */
public class TimeChecker {
    private boolean visible = true;
    private boolean first = true;
    private long startTime;
    private long waitTimeInSec;
    private String descr;
    private boolean simple = false;
    /**
     * Static variable for analyze we have or not printed timer scroll.
     */
    public static boolean printed = false;

    /**
     * <h2>Initialize timer</h2> Initialize timer and start for .. seconds.
     * After end of time isElapsed return true. <br>
     * <br>
     */
    public TimeChecker() {
        setDescr("");
        start();
    }

    /**
     * <h2>Initialize timer</h2> Initialize timer and start for .. seconds.
     * After end of time isElapsed return true. <br>
     * <br>
     *
     * @param seconds
     *            Seconds to wait
     */
    public TimeChecker(int seconds, boolean visible) {
        setDescr("");

        this.visible = visible;
        start(seconds);
    }

    /**
     * <h2>Initialize timer</h2> Initialize timer and start for .. seconds.
     * After end of time isElapsed return true. <br>
     * <br>
     *
     * @param seconds
     *            Seconds to wait
     * @deprecated need use with description parameter!
     */
    @Deprecated
    public TimeChecker(int seconds) {
        setDescr("");
        start(seconds);
    }

    private void setDescr(String name) {
        descr = name;
        if (descr != null && !descr.trim().isEmpty())
            return;

        descr = "Pause";
//        try {
//            StackTraceElement[] x = LogHelper.getCleanTrace(CleanType.ERROR);
//
//            for (int i = 1; i < x.length; i++) {
//                if (!x[i].getMethodName().equals("wait")
//                        && !x[i].getMethodName().equals("pause")
//                        && !x[i].getClassName().equals(
//                        this.getClass().getName())) {
//                    descr += " at " + x[i];
//                    break;
//                }
//            }
//
//        } catch (Exception e) {
            // Ignore
//        }
    }

    /**
     * <h2>Initialize timer</h2> Initialize timer and start for .. seconds.
     *
     * @param seconds
     *            Seconds to wait
     * @param description
     *            Action description
     */
    public TimeChecker(int seconds, String description) {
        setDescr(description);
        start(seconds);
    }

    /**
     * <h2>Restart timer</h2> Clean last timer result and start timer again.
     *
     */
    public void start() {
        startTime = System.currentTimeMillis();
        printedSeconds = 0;
        if (printed) {
            visible = false;
            System.out.print(":");
        }
    }

    /**
     * Start timer for timeout = "seconds"
     *
     * @param secunds
     *            Timeout length
     */
    public void start(long secunds) {
        startTime = System.currentTimeMillis();
        waitTimeInSec = secunds;
        if (printed) {
            System.out.print(":");
            visible = false;
        }
    }

    /**
     * <h2>Simple time check</h2> Without any printing
     *
     * @param simple
     *            True for simple
     */
    public void setSimple(boolean simple) {
        this.simple = simple;
    }

    /**
     * State of timeout
     *
     * @return true if is end timeout wait
     */
    public boolean isElapsed() {
        boolean isElapsedTime = false;
        if (!first)
            try {
                Thread.sleep(150);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        first = false;
        if (!simple)
            if (getElapsedTimeInSec() > 2) {
                if (!visible)
                    System.out.print(":");
                else if (!printed) {
//                    LogHelper.update();
                    printed = true;
                    System.out.println("\nWait " + waitTimeInSec + " sec");
                    if (!descr.isEmpty())
                        System.out.println(descr);
                    System.out.print("\n[0..");
                } else if (printedSeconds < Math.round(getElapsedTimeInSec())) {
                    // System.out.println( Math.round( printedSeconds / 10 ) );
                    if ((int) getElapsedTimeInSec() % 10 == 0
                            && printedSeconds > 2)
                        System.out.print((int) getElapsedTimeInSec());
                    else
                        System.out.print(".");
                    printedSeconds = (int) getElapsedTimeInSec();
                }
            }

        if (getElapsedTimeInSec() >= waitTimeInSec) {
            if (visible) {
                if (printed)
                    System.out.print("]\n");

                printed = false;
            }
            isElapsedTime = true;

//			LogHelper.warning("Timeout for " + descr + " is elapsed");

        }
        return isElapsedTime;

    }

    private int printedSeconds = 0;

    /**
     * Get elapsed time in milliseconds
     *
     * @return milliseconds count from start
     */
    public long getElapsedTimeInMillisec() {
        long currentTime = System.currentTimeMillis();
        long timeElapsed = currentTime - startTime;
        return timeElapsed;

    }

    /**
     * Get elapsed time in seconds
     *
     * @return seconds count from start
     */
    public long getElapsedTimeInSec() {
        return getElapsedTimeInMillisec() / 1000;
    }

    /**
     * Stop timer
     */
    public void stop() {
        waitTimeInSec = 0;
        if (visible)
            breakOut();
    }

    /**
     *
     */
    public static void breakOut() {
        if (printed) {
            System.out.println("]");
            printed = false;
        }
    }
}
