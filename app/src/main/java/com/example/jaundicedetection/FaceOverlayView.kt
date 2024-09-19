import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View
import com.google.mlkit.vision.face.Face

class FaceOverlayView(context: Context, attrs: AttributeSet?) : View(context, attrs) {
    private val paint = Paint().apply {
        color = Color.GREEN
        style = Paint.Style.STROKE
        strokeWidth = 5f
    }

    private var leftEyeRect: RectF? = null
    private var rightEyeRect: RectF? = null

    fun setEyesBoundingBoxes(leftEye: RectF?, rightEye: RectF?) {
        leftEyeRect = leftEye
        rightEyeRect = rightEye
        invalidate() // Redraw the view
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        leftEyeRect?.let {
            canvas.drawRect(it, paint)
        }

        rightEyeRect?.let {
            canvas.drawRect(it, paint)
        }
    }
}
