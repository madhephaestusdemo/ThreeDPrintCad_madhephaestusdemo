
import java.time.Duration;

import java.util.ArrayList;

import javafx.application.Platform;

import org.reactfx.util.FxTimer;

import com.neuronrobotics.sdk.addons.kinematics.DHParameterKinematics;
import com.neuronrobotics.sdk.addons.kinematics.MobileBase;
import com.neuronrobotics.sdk.addons.kinematics.math.RotationNR;
import com.neuronrobotics.sdk.addons.kinematics.math.TransformNR;
import com.neuronrobotics.sdk.util.ThreadUtil;
import com.neuronrobotics.sdk.addons.kinematics.IDriveEngine;


	double stepOverHeight=5;
	long stepOverTime=40;
	Double zLock=0;
	Closure calcHome = { DHParameterKinematics leg -> 
			TransformNR h=leg.calcHome() 
	 		TransformNR  legRoot= leg.getRobotToFiducialTransform()
			TransformNR tr = leg.forwardOffset(new TransformNR())
			tr.setZ(zLock)
			//Bambi-on-ice the legs a bit
			if(legRoot.getY()>0){
				//tr.translateY(-5)
			}else{
				//tr.translateY(5)
			}
			
			return h;
	
	}
	boolean usePhysicsToMove = true;
	long stepCycleTime =5000
	int numStepCycleGroups = 6
	double standardHeadTailAngle = -20
	double staticPanOffset = 10
	double coriolisGain = 1
	boolean headStable = false
	double maxBodyDisplacementPerStep = 20
	double minBodyDisplacementPerStep = 5
	def ar =  [stepOverHeight,
	stepOverTime,
	zLock,
	calcHome,
	usePhysicsToMove,
	stepCycleTime,
	numStepCycleGroups,
	standardHeadTailAngle,
	staticPanOffset,
	coriolisGain,
	headStable,
	maxBodyDisplacementPerStep,
	minBodyDisplacementPerStep]


return ScriptingEngine
          .gitScriptRun(
            "https://github.com/keionbis/SmallKat.git", // git location of the library
            "Bowler/DynamicWalking.groovy" , // file to load
            ar
         )
                       