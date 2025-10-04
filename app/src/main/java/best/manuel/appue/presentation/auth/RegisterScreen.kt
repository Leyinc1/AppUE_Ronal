package best.manuel.appue.presentation.auth

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun RegisterScreen(
    onSuccessfulRegister: () -> Unit,
    onNavigateToLogin: () -> Unit
) {
    Surface(
        color = appBackground, // Usamos el color de fondo genérico
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(60.dp))

            // --- Título de la Pantalla ---
            Text(
                text = "Crea una cuenta",
                color = Color.White,
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(48.dp))

            // --- Campos de Entrada (simulados) ---
            OutlinedTextField(
                value = "",
                onValueChange = {},
                label = { Text("Correo electrónico") },
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.DarkGray,
                    unfocusedContainerColor = Color.DarkGray,
                    focusedIndicatorColor = primaryActionBlue
                )
            )
            Spacer(modifier = Modifier.height(16.dp))
            OutlinedTextField(
                value = "",
                onValueChange = {},
                label = { Text("Contraseña") },
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.DarkGray,
                    unfocusedContainerColor = Color.DarkGray,
                    focusedIndicatorColor = primaryActionBlue
                )
            )
            Spacer(modifier = Modifier.height(32.dp))

            // --- Botón de Registro ---
            Button(
                onClick = onSuccessfulRegister, // Navega a la playlist
                shape = RoundedCornerShape(50),
                colors = ButtonDefaults.buttonColors(containerColor = primaryActionBlue),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "REGISTRARSE",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    modifier = Modifier.padding(vertical = 8.dp)
                )
            }
            Spacer(modifier = Modifier.height(24.dp))

            // --- Navegación a Login ---
            TextButton(onClick = onNavigateToLogin) {
                Text(
                    "¿Ya tienes una cuenta? Inicia sesión",
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}