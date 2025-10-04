package best.manuel.appue.presentation.auth

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MusicNote // Ícono más apropiado
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// --- Colores de la Marca ---
val primaryActionBlue = Color(0xFF2F81F7) // Un azul similar al de GitHub
val appBackground = Color(0xFF191414)

@Composable
fun LoginScreen(
    onSuccessfulLogin: () -> Unit,
    onNavigateToRegister: () -> Unit // Parámetro para navegar a Registro
) {
    Surface(
        color = appBackground,
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            // --- Sección Superior: Logo y Eslogan ---
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Spacer(modifier = Modifier.height(60.dp))
                Icon(
                    imageVector = Icons.Default.MusicNote,
                    contentDescription = "App Logo",
                    tint = Color.White,
                    modifier = Modifier.size(64.dp)
                )
                Spacer(modifier = Modifier.height(32.dp))
                Text(
                    text = "Descubre nueva música.\nGratis en nuestra App.",
                    color = Color.White,
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    lineHeight = 40.sp
                )
            }

            // --- Sección Inferior: Botones de Acción ---
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth()
            ) {
                Button(
                    onClick = onSuccessfulLogin, // Navega a la playlist
                    shape = RoundedCornerShape(50),
                    colors = ButtonDefaults.buttonColors(containerColor = primaryActionBlue),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "INICIAR SESIÓN",
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp,
                        modifier = Modifier.padding(vertical = 8.dp)
                    )
                }
                Spacer(modifier = Modifier.height(12.dp))

                // --- Botones de Redes Sociales (funcionales) ---
                SocialLoginButton(
                    text = "Continuar con Google",
                    icon = Icons.Default.MusicNote,
                    onClick = { /* TODO: Lógica de login con Google */ }
                )
                Spacer(modifier = Modifier.height(8.dp))
                SocialLoginButton(
                    text = "Continuar con GitHub",
                    icon = Icons.Default.MusicNote,
                    onClick = { /* TODO: Lógica de login con GitHub */ }
                )
                Spacer(modifier = Modifier.height(8.dp))
                SocialLoginButton(
                    text = "Continuar con Apple",
                    icon = Icons.Default.MusicNote,
                    onClick = { /* TODO: Lógica de login con Apple */ }
                )
                Spacer(modifier = Modifier.height(24.dp))

                // --- Botón para navegar al registro (restaurado) ---
                TextButton(onClick = onNavigateToRegister) {
                    Text(
                        "Registrarse gratis",
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp
                    )
                }
            }
        }
    }
}

@Composable
fun SocialLoginButton(
    text: String,
    icon: ImageVector,
    onClick: () -> Unit
) {
    OutlinedButton(
        onClick = onClick,
        shape = RoundedCornerShape(50),
        border = BorderStroke(1.dp, Color.White),
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = icon,
                contentDescription = null, 
                tint = Color.White,
                modifier = Modifier.size(24.dp)
            )
            Text(
                text = text,
                color = Color.White,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier.weight(1f) 
            )
        }
    }
}